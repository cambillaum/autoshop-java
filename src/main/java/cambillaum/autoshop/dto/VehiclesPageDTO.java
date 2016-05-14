package cambillaum.autoshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class VehiclesPageDTO {

    private final Integer totalNumberOfVehicles;
    private final List<VehicleCategoryWithNumberDTO> numberOfVehiclesByCategory;
    private final List<VehicleDTO> vehiclesInPage;

    public VehiclesPageDTO(
        @JsonProperty("totalNumberOfVehicles")  final Integer totalNumberOfVehicles,
        @JsonProperty("numberOfVehiclesByCategory") @JsonDeserialize(contentAs = VehicleCategoryWithNumberDTO.class) final List<VehicleCategoryWithNumberDTO> numberOfVehiclesByCategory,
        @JsonProperty("vehiclesInPage") final List<VehicleDTO> vehiclesInPage
    ) {
        this.totalNumberOfVehicles = totalNumberOfVehicles;
        this.numberOfVehiclesByCategory = numberOfVehiclesByCategory;
        this.vehiclesInPage = vehiclesInPage;
    }

    @Override
    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toStringBuilder.append("totalNumberOfVehicles", totalNumberOfVehicles);
        toStringBuilder.append("numberOfVehiclesByCategory", numberOfVehiclesByCategory);
        toStringBuilder.append("vehiclesInPage", vehiclesInPage);

        return toStringBuilder.toString();
    }

    @JsonProperty("totalNumberOfVehicles")
    public Integer totalNumberOfVehicles() {
        return totalNumberOfVehicles;
    }

    @JsonProperty("numberOfVehiclesByCategory")
    public List<VehicleCategoryWithNumberDTO> numberOfVehiclesByCategory() {
        return numberOfVehiclesByCategory;
    }

    @JsonProperty("vehiclesInPage")
    public List<VehicleDTO> vehiclesInPage() {
        return vehiclesInPage;
    }
}
