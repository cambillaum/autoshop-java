package cambillaum.autoshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CarDTO implements VehicleDTO {

    private final String id;
    private final String name;
    private final Double dollarPrice;
    private final Integer modelYear;
    private final String carType;
    private final Integer doorsNumber;

    @JsonCreator
    public CarDTO(
        @JsonProperty("id") final String id,
        @JsonProperty("name") final String name,
        @JsonProperty("dollarPrice") final Double dollarPrice,
        @JsonProperty("modelYear") final Integer modelYear,
        @JsonProperty("carType") final String carType,
        @JsonProperty("doorsNumber") final Integer doorsNumber
    ) {
        this.id = id;
        this.name = name;
        this.dollarPrice = dollarPrice;
        this.modelYear = modelYear;
        this.carType = carType;
        this.doorsNumber = doorsNumber;
    }

    @Override
    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toStringBuilder.append("id", id);
        toStringBuilder.append("name", name);
        toStringBuilder.append("dollarPrice", dollarPrice);
        toStringBuilder.append("modelYear", modelYear);
        toStringBuilder.append("carType", carType);
        toStringBuilder.append("doorsNumber", doorsNumber);

        return toStringBuilder.toString();
    }

    @Override
    @JsonProperty("vehicleType")
    public String vehicleType() {
        return "car";
    }

    @JsonProperty("carType")
    public String carType() {
        return carType;
    }

    @Override
    @JsonProperty("id")
    public String id() {
        return id;
    }

    @Override
    @JsonProperty("name")
    public String name() {
        return name;
    }

    @Override
    @JsonProperty("dollarPrice")
    public Double dollarPrice() {
        return dollarPrice;
    }

    @Override
    @JsonProperty("modelYear")
    public Integer modelYear() {
        return modelYear;
    }

    @JsonProperty("doorsNumber")
    public Integer doorsNumber() {
        return doorsNumber;
    }
}
