package org.openapitools.api;

import org.openapitools.model.Booking;
import org.openapitools.model.BookingRequest;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.time.Duration;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-26T17:15:28.044987462Z[Etc/UTC]", comments = "Generator version: 7.21.0-SNAPSHOT")
@Controller
@RequestMapping("${openapi..base-path:}")
public class BookingsApiController implements BookingsApi {

    private static final Logger log = LoggerFactory.getLogger(BookingsApiController.class);
    private final NativeWebRequest request;

    @Autowired
    private MetricsService metricsService;

    @Autowired
    private ObservationRegistry observationRegistry;

    @Autowired
    public BookingsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Booking> bookingsPost(@Valid BookingRequest bookingRequest) {
        // Кастомный спан: валидация бронирования
        Observation validationSpan = Observation.createNotStarted("booking.validation", observationRegistry)
                .lowCardinalityKeyValue("room.id", bookingRequest.getRoomId().toString())
                .start();

        try {
            log.info("Booking request received: roomId={}, startTime={}, endTime={}, title={}",
                    bookingRequest.getRoomId(),
                    bookingRequest.getStartTime(),
                    bookingRequest.getEndTime(),
                    bookingRequest.getTitle());

            Observation creationSpan = Observation.createNotStarted("booking.create", observationRegistry)
                    .lowCardinalityKeyValue("room.id", bookingRequest.getRoomId().toString())
                    .start();

            try {
                // ВРЕМЕННАЯ ЗАГЛУШКА
                Booking booking = new Booking();
                booking.setId(1);
                booking.setRoomId(bookingRequest.getRoomId());
                booking.setStartTime(bookingRequest.getStartTime());
                booking.setEndTime(bookingRequest.getEndTime());
                booking.setTitle(bookingRequest.getTitle());

                metricsService.recordBookingCreated();

                if (bookingRequest.getStartTime() != null && bookingRequest.getEndTime() != null) {
                    Duration duration = Duration.between(
                            bookingRequest.getStartTime(),
                            bookingRequest.getEndTime()
                    );
                    metricsService.recordBookingDuration(duration);
                }

                metricsService.recordBookingByRoom(
                        bookingRequest.getRoomId(),
                        "room_" + bookingRequest.getRoomId()
                );

                log.info("Booking created successfully: bookingId={}, roomId={}",
                        booking.getId(), booking.getRoomId());
                return new ResponseEntity<>(booking, HttpStatus.CREATED);
            } finally {
                creationSpan.stop();
            }
        } catch (Exception e) {
            log.error("Failed to create booking: roomId={}, error={}",
                    bookingRequest.getRoomId(), e.getMessage(), e);
            validationSpan.error(e);
            throw e;
        } finally {
            validationSpan.stop();
        }
    }

    @Override
    public ResponseEntity<Void> bookingsBookingIdDelete(Integer bookingId) {
        // Кастомный спан: отмена бронирования
        Observation cancellationSpan = Observation.createNotStarted("booking.cancel", observationRegistry)
                .lowCardinalityKeyValue("booking.id", bookingId.toString())
                .start();

        try {
            log.info("Booking cancellation requested: bookingId={}", bookingId);
            metricsService.recordBookingCancelled();
            log.info("Booking cancelled successfully: bookingId={}", bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Failed to cancel booking: bookingId={}, error={}",
                    bookingId, e.getMessage(), e);
            cancellationSpan.error(e);
            throw e;
        } finally {
            cancellationSpan.stop();
        }
    }

    @Override
    public ResponseEntity<Booking> getBooking(Integer bookingId) {
        log.debug("Get booking requested: bookingId={}", bookingId);
        Booking booking = new Booking();
        booking.setId(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}