package cambillaum.autoshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MotorcycleDTO implements VehicleDTO {

    private final String id;
    private final String name;
    private final Double dollarPrice;
    private final Integer modelYear;
    private final Boolean hasSidecar;

    @JsonCreator
    public MotorcycleDTO(
        @JsonProperty("id") final String id,
        @JsonProperty("name") final String name,
        @JsonProperty("dollarPrice") final Double dollarPrice,
        @JsonProperty("modelYear") final Integer modelYear,
        @JsonProperty("hasSidecar") final Boolean hasSidecar
    ) {
        this.id = id;
        this.name = name;
        this.dollarPrice = dollarPrice;
        this.modelYear = modelYear;
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toStringBuilder.append("id", id);
        toStringBuilder.append("name", name);
        toStringBuilder.append("dollarPrice", dollarPrice);
        toStringBuilder.append("modelYear", modelYear);
        toStringBuilder.append("hasSidecar", hasSidecar);

        return toStringBuilder.toString();
    }

    @Override
    @JsonProperty("vehicleType")
    public String vehicleType() {
        return "motorcycle";
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

    @JsonProperty("hasSidecar")
    public Boolean hasSidecar() {
        return hasSidecar;
    }
}
