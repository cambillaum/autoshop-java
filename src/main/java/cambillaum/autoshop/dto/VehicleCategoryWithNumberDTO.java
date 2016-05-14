package cambillaum.autoshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class VehicleCategoryWithNumberDTO {

    private final String category;
    private final Integer numberOfVehicles;

    @JsonCreator
    public VehicleCategoryWithNumberDTO(
        @JsonProperty("category") final String category,
        @JsonProperty("numberOfVehicles") final Integer numberOfVehicles
    ) {
        this.category = category;
        this.numberOfVehicles = numberOfVehicles;
    }

    @Override
    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toStringBuilder.append("category", category);
        toStringBuilder.append("numberOfVehicles", numberOfVehicles);

        return toStringBuilder.toString();
    }

    @JsonProperty("category")
    public String category() {
        return category;
    }

    @JsonProperty("numberOfVehicles")
    public Integer numberOfVehicles() {
        return numberOfVehicles;
    }
}
