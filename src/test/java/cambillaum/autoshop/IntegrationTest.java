package cambillaum.autoshop;

import cambillaum.autoshop.config.AutoShopConfig;
import cambillaum.autoshop.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AutoShopConfig.class)
@WebIntegrationTest(randomPort = true)
public class IntegrationTest {

    @Value("${local.server.port}")
    private final Integer port = null;
    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testVehiclesPage() {
        VehiclesPageDTO response = restTemplate.getForObject("http://localhost:" + port + "/vehicles/page?numberOfVehiclesPerPage=3&offset=0", VehiclesPageDTO.class);
        assertTotalNumberOfVehicles(response);
        assertNumberOfVehiclesByCategory(response.numberOfVehiclesByCategory());
        assertVehiclesInPage(response.vehiclesInPage());
    }

    private void assertTotalNumberOfVehicles(VehiclesPageDTO vehiclesPageDTO) {
        assertThat("totalNumberOfVehicles does not match expected", vehiclesPageDTO.totalNumberOfVehicles(), equalTo(6));
    }

    private void assertNumberOfVehiclesByCategory(List<VehicleCategoryWithNumberDTO> vehicleCategoryWithNumberDTOs) {
        assertThat("number of vehicles categories does not match expected", vehicleCategoryWithNumberDTOs.size(), equalTo(4));

        VehicleCategoryWithNumberDTO vehicleCategoryWithNumberDTO0 = vehicleCategoryWithNumberDTOs.get(0);
        assertThat("vehicle category does not match expected", vehicleCategoryWithNumberDTO0.category(), equalTo("SUV"));
        assertThat("number of vehicles in category does not match expected", vehicleCategoryWithNumberDTO0.numberOfVehicles(), equalTo(1));

        VehicleCategoryWithNumberDTO vehicleCategoryWithNumberDTO1 = vehicleCategoryWithNumberDTOs.get(1);
        assertThat("vehicle category does not match expected", vehicleCategoryWithNumberDTO1.category(), equalTo("Sedan"));
        assertThat("number of vehicles in category does not match expected", vehicleCategoryWithNumberDTO1.numberOfVehicles(), equalTo(1));

        VehicleCategoryWithNumberDTO vehicleCategoryWithNumberDTO2 = vehicleCategoryWithNumberDTOs.get(2);
        assertThat("vehicle category does not match expected", vehicleCategoryWithNumberDTO2.category(), equalTo("Truck"));
        assertThat("number of vehicles in category does not match expected", vehicleCategoryWithNumberDTO2.numberOfVehicles(), equalTo(1));

        VehicleCategoryWithNumberDTO vehicleCategoryWithNumberDTO3 = vehicleCategoryWithNumberDTOs.get(3);
        assertThat("vehicle category does not match expected", vehicleCategoryWithNumberDTO3.category(), equalTo("Motorcycle"));
        assertThat("number of vehicles in category does not match expected", vehicleCategoryWithNumberDTO3.numberOfVehicles(), equalTo(3));
    }

    private void assertVehiclesInPage(List<VehicleDTO> vehicleDTOs) {
        assertThat("number of vehicles in page does not match expected", vehicleDTOs.size(), equalTo(3));

        VehicleDTO vehicleDTO0 = vehicleDTOs.get(0);
        assertThat("vehicle is not of the expected type", vehicleDTO0, instanceOf(CarDTO.class));
        CarDTO carDTO0 = (CarDTO) vehicleDTO0;
        assertThat("id does not match expected", carDTO0.id(), equalTo("car1"));
        assertThat("name does not match expected", carDTO0.name(), equalTo("Car For Sale 1"));
        assertThat("dollarPrice does not match expected", carDTO0.dollarPrice(), equalTo(1_000D));
        assertThat("modelYear does not match expected", carDTO0.modelYear(), equalTo(2000));
        assertThat("carType does not match expected", carDTO0.carType(), equalTo("SEDAN"));
        assertThat("doorsNumber does not match expected", carDTO0.doorsNumber(), equalTo(3));
        assertThat("vehicleType does not match expected", carDTO0.vehicleType(), equalTo("car"));

        VehicleDTO vehicleDTO1 = vehicleDTOs.get(1);
        assertThat("vehicle is not of the expected type", vehicleDTO1, instanceOf(MotorcycleDTO.class));
        MotorcycleDTO motorcyleDTO1 = (MotorcycleDTO) vehicleDTO1;
        assertThat("id does not match expected", motorcyleDTO1.id(), equalTo("motorcycle2"));
        assertThat("name does not match expected", motorcyleDTO1.name(), equalTo("Motorcycle For Sale 2"));
        assertThat("dollarPrice does not match expected", motorcyleDTO1.dollarPrice(), equalTo(3_000D));
        assertThat("modelYear does not match expected", motorcyleDTO1.modelYear(), equalTo(2010));
        assertThat("hasSidecar does not match expected", motorcyleDTO1.hasSidecar(), equalTo(false));
        assertThat("vehicleType does not match expected", motorcyleDTO1.vehicleType(), equalTo("motorcycle"));

        VehicleDTO vehicleDTO2 = vehicleDTOs.get(2);
        assertThat("vehicle is not of the expected type", vehicleDTO2, instanceOf(CarDTO.class));
        CarDTO carDTO2 = (CarDTO) vehicleDTO2;
        assertThat("id does not match expected", carDTO2.id(), equalTo("car3"));
        assertThat("name does not match expected", carDTO2.name(), equalTo("Car For Sale 3"));
        assertThat("dollarPrice does not match expected", carDTO2.dollarPrice(), equalTo(5_000D));
        assertThat("modelYear does not match expected", carDTO2.modelYear(), equalTo(2007));
        assertThat("carType does not match expected", carDTO2.carType(), equalTo("TRUCK"));
        assertThat("doorsNumber does not match expected", carDTO2.doorsNumber(), equalTo(5));
        assertThat("vehicleType does not match expected", carDTO2.vehicleType(), equalTo("car"));
    }


}
