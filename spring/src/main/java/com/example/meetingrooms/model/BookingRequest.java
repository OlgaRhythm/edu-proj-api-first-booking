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
 * BookingRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-26T17:15:28.044987462Z[Etc/UTC]", comments = "Generator version: 7.21.0-SNAPSHOT")
public class BookingRequest {

  private Integer roomId;

  private @Nullable String title;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTime;

  public BookingRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingRequest(Integer roomId, OffsetDateTime startTime, OffsetDateTime endTime) {
    this.roomId = roomId;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public BookingRequest roomId(Integer roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * ID переговорки
   * minimum: 1
   * @return roomId
   */
  @NotNull @Min(value = 1) 
  @Schema(name = "room_id", example = "1", description = "ID переговорки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("room_id")
  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public BookingRequest title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Название встречи (опционально)
   * @return title
   */
  
  @Schema(name = "title", example = "Планирование спринта", description = "Название встречи (опционально)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public BookingRequest startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Дата и время начала
   * @return startTime
   */
  @NotNull @Valid 
  @Schema(name = "start_time", example = "2024-01-20T14:00Z", description = "Дата и время начала", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("start_time")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public BookingRequest endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Дата и время окончания
   * @return endTime
   */
  @NotNull @Valid 
  @Schema(name = "end_time", example = "2024-01-20T15:00Z", description = "Дата и время окончания", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("end_time")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingRequest bookingRequest = (BookingRequest) o;
    return Objects.equals(this.roomId, bookingRequest.roomId) &&
        Objects.equals(this.title, bookingRequest.title) &&
        Objects.equals(this.startTime, bookingRequest.startTime) &&
        Objects.equals(this.endTime, bookingRequest.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomId, title, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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

