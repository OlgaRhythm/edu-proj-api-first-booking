package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Booking
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-26T17:15:28.044987462Z[Etc/UTC]", comments = "Generator version: 7.21.0-SNAPSHOT")
public class Booking {

  private Integer id;

  private Integer roomId;

  private @Nullable String roomName;

  private String bookedBy;

  private @Nullable String title;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  public Booking() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Booking(Integer id, Integer roomId, String bookedBy, OffsetDateTime startTime, OffsetDateTime endTime) {
    this.id = id;
    this.roomId = roomId;
    this.bookedBy = bookedBy;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Booking id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор бронирования
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "42", description = "Уникальный идентификатор бронирования", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Booking roomId(Integer roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * ID переговорки
   * @return roomId
   */
  @NotNull 
  @Schema(name = "room_id", example = "1", description = "ID переговорки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("room_id")
  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Booking roomName(@Nullable String roomName) {
    this.roomName = roomName;
    return this;
  }

  /**
   * Название переговорки (для удобства)
   * @return roomName
   */
  
  @Schema(name = "room_name", example = "Конференц-зал А", description = "Название переговорки (для удобства)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("room_name")
  public @Nullable String getRoomName() {
    return roomName;
  }

  public void setRoomName(@Nullable String roomName) {
    this.roomName = roomName;
  }

  public Booking bookedBy(String bookedBy) {
    this.bookedBy = bookedBy;
    return this;
  }

  /**
   * Email или имя того, кто забронировал
   * @return bookedBy
   */
  @NotNull 
  @Schema(name = "booked_by", example = "alex@company.com", description = "Email или имя того, кто забронировал", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("booked_by")
  public String getBookedBy() {
    return bookedBy;
  }

  public void setBookedBy(String bookedBy) {
    this.bookedBy = bookedBy;
  }

  public Booking title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Название встречи
   * @return title
   */
  
  @Schema(name = "title", example = "Спринт-ревью", description = "Название встречи", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public Booking startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Дата и время начала
   * @return startTime
   */
  @NotNull @Valid 
  @Schema(name = "start_time", example = "2024-01-20T10:00Z", description = "Дата и время начала", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("start_time")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Booking endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Дата и время окончания
   * @return endTime
   */
  @NotNull @Valid 
  @Schema(name = "end_time", example = "2024-01-20T11:30Z", description = "Дата и время окончания", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("end_time")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public Booking createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Дата и время создания бронирования
   * @return createdAt
   */
  @Valid 
  @Schema(name = "created_at", example = "2024-01-19T15:30Z", description = "Дата и время создания бронирования", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.id, booking.id) &&
        Objects.equals(this.roomId, booking.roomId) &&
        Objects.equals(this.roomName, booking.roomName) &&
        Objects.equals(this.bookedBy, booking.bookedBy) &&
        Objects.equals(this.title, booking.title) &&
        Objects.equals(this.startTime, booking.startTime) &&
        Objects.equals(this.endTime, booking.endTime) &&
        Objects.equals(this.createdAt, booking.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, roomId, roomName, bookedBy, title, startTime, endTime, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    roomName: ").append(toIndentedString(roomName)).append("\n");
    sb.append("    bookedBy: ").append(toIndentedString(bookedBy)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

