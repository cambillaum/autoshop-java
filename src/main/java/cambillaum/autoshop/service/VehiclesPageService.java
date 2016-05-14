package cambillaum.autoshop.service;

import cambillaum.autoshop.dto.VehiclesPageDTO;

public interface VehiclesPageService {
    VehiclesPageDTO loadVehiclesPage(Integer numberOfVehiclesPerPage, Integer offset);
}
