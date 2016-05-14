package cambillaum.autoshop.store;

import cambillaum.autoshop.domain.Vehicle;

import java.util.Set;

public interface VehiclesStore {

    Set<Vehicle> loadAllVehicles();

}
