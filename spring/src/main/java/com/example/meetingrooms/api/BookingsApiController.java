package org.openapitools.api;

import org.openapitools.model.Booking;
import org.openapitools.model.BookingRequest;
import org.openapitools.api.MetricsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.time.Duration;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-26T17:15:28.044987462Z[Etc/UTC]", comments = "Generator version: 7.21.0-SNAPSHOT")
@Controller
@RequestMapping("${openapi..base-path:}")
public class BookingsApiController implements BookingsApi {

    private final NativeWebRequest request;

    @Autowired
    private MetricsService metricsService;

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

        // ВРЕМЕННАЯ ЗАГЛУШКА
        Booking booking = new Booking();
        booking.setId(1);
        booking.setRoomId(bookingRequest.getRoomId());
        booking.setStartTime(bookingRequest.getStartTime());
        booking.setEndTime(bookingRequest.getEndTime());
        booking.setTitle(bookingRequest.getTitle());

        // Количество созданных бронирований
        metricsService.recordBookingCreated();

        // Длительность бронирования
        if (bookingRequest.getStartTime() != null && bookingRequest.getEndTime() != null) {
            Duration duration = Duration.between(
                    bookingRequest.getStartTime(),
                    bookingRequest.getEndTime()
            );
            metricsService.recordBookingDuration(duration);
        }

        // Бронирования по комнатам (с тегами)
        metricsService.recordBookingByRoom(
                bookingRequest.getRoomId(),
                "room_" + bookingRequest.getRoomId()
        );

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> bookingsBookingIdDelete(Integer bookingId) {

        // Количество отменённых бронирований
        metricsService.recordBookingCancelled();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Booking> getBooking(Integer bookingId) {
        // Временная заглушка
        Booking booking = new Booking();
        booking.setId(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

}
