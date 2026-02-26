package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Room
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-26T17:15:28.044987462Z[Etc/UTC]", comments = "Generator version: 7.21.0-SNAPSHOT")
public class Room {

  private Integer id;

  private String name;

  private Integer capacity;

  /**
   * Gets or Sets equipment
   */
  public enum EquipmentEnum {
    PROJECTOR("projector"),
    
    TV("tv"),
    
    WHITEBOARD("whiteboard"),
    
    VIDEOCONFERENCE("videoconference"),
    
    SPEAKER("speaker");

    private final String value;

    EquipmentEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EquipmentEnum fromValue(String value) {
      for (EquipmentEnum b : EquipmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private List<EquipmentEnum> equipment = new ArrayList<>();

  public Room() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Room(Integer id, String name, Integer capacity) {
    this.id = id;
    this.name = name;
    this.capacity = capacity;
  }

  public Room id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор комнаты
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "1", description = "Уникальный идентификатор комнаты", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Room name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название переговорки
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Конференц-зал А", description = "Название переговорки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Вместимость (человек)
   * minimum: 1
   * @return capacity
   */
  @NotNull @Min(value = 1) 
  @Schema(name = "capacity", example = "10", description = "Вместимость (человек)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("capacity")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Room equipment(List<EquipmentEnum> equipment) {
    this.equipment = equipment;
    return this;
  }

  public Room addEquipmentItem(EquipmentEnum equipmentItem) {
    if (this.equipment == null) {
      this.equipment = new ArrayList<>();
    }
    this.equipment.add(equipmentItem);
    return this;
  }

  /**
   * Оснащение комнаты
   * @return equipment
   */
  
  @Schema(name = "equipment", example = "[\"projector\",\"whiteboard\"]", description = "Оснащение комнаты", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("equipment")
  public List<EquipmentEnum> getEquipment() {
    return equipment;
  }

  public void setEquipment(List<EquipmentEnum> equipment) {
    this.equipment = equipment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.id, room.id) &&
        Objects.equals(this.name, room.name) &&
        Objects.equals(this.capacity, room.capacity) &&
        Objects.equals(this.equipment, room.equipment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, capacity, equipment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
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

