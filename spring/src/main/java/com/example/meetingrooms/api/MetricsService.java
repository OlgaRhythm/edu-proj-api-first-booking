package org.openapitools.api;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class MetricsService {

    private final Counter bookingsCreatedCounter;
    private final Counter bookingsCancelledCounter;
    private final Counter bookingsByRoomCounter;
    private final Timer bookingDurationTimer;
    private final MeterRegistry registry;

    public MetricsService(MeterRegistry registry) {
        this.registry = registry;
        // Количество созданных бронирований
        this.bookingsCreatedCounter = Counter.builder("bookings.created.total")
                .description("Total number of bookings created")
                .register(registry);

        // Количество отменённых бронирований
        this.bookingsCancelledCounter = Counter.builder("bookings.cancelled.total")
                .description("Total number of bookings cancelled")
                .register(registry);

        // Бронирования по комнатам (с тегами)
        this.bookingsByRoomCounter = Counter.builder("bookings.by.room.total")
                .description("Bookings per room")
                .register(registry);

        // Длительность бронирования
        this.bookingDurationTimer = Timer.builder("booking.duration.seconds")
                .description("Duration of booking in seconds")
                .publishPercentiles(0.5, 0.9, 0.95)
                .register(registry);
    }

    public void recordBookingCreated() {
        bookingsCreatedCounter.increment();
    }

    public void recordBookingCancelled() {
        bookingsCancelledCounter.increment();
    }

    public void recordBookingByRoom(Integer roomId, String roomName) {
        // Просто создаём отдельный счётчик для каждой комнаты
        Counter.builder("bookings.room." + roomId)
                .description("Bookings for room " + roomId + " - " + roomName)
                .register(registry)
                .increment();
    }

    public void recordBookingDuration(Duration duration) {
        bookingDurationTimer.record(duration);
    }
}