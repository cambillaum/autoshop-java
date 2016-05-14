package cambillaum.autoshop.controller;

import cambillaum.autoshop.dto.VehiclesPageDTO;
import cambillaum.autoshop.service.VehiclesPageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehicles", produces = "application/json")
public class AutoShopController {

    private final VehiclesPageService vehiclesPageService;

    public AutoShopController(final VehiclesPageService vehiclesPageService) {
        this.vehiclesPageService = vehiclesPageService;
    }

    @RequestMapping("/page")
    public VehiclesPageDTO loadVehiclesPage(@RequestParam("numberOfVehiclesPerPage") Integer numberOfVehiclesPerPage, @RequestParam("offset") Integer offset) {
        return vehiclesPageService.loadVehiclesPage(numberOfVehiclesPerPage, offset);
    }

}
