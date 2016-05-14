package cambillaum.autoshop.config;

import cambillaum.autoshop.controller.AutoShopController;
import cambillaum.autoshop.service.VehiclesPageService;
import cambillaum.autoshop.service.VehiclesPageServiceImpl;
import cambillaum.autoshop.store.MockVehiclesStore;
import cambillaum.autoshop.store.VehiclesStore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class AutoShopConfig {

    @Bean
    public VehiclesStore vehiclesStore() {
        return new MockVehiclesStore();
    }

    @Bean
    public VehiclesPageService vehiclesPageService() {
        return new VehiclesPageServiceImpl(vehiclesStore());
    }

    @Bean
    public AutoShopController controller() {
        return new AutoShopController(vehiclesPageService());
    }

}
