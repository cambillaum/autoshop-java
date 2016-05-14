package cambillaum.autoshop.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "vehicleType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = CarDTO.class, name = "car"),
    @JsonSubTypes.Type(value = MotorcycleDTO.class, name="motorcycle")
})
public interface VehicleDTO {

    String vehicleType();
    String id();
    String name();
    Double dollarPrice();
    Integer modelYear();

}
