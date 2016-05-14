package cambillaum.autoshop.store;

import cambillaum.autoshop.domain.*;

import java.time.Year;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MockVehiclesStore implements VehiclesStore {

    private final Set<Vehicle> vehicles;

    public MockVehiclesStore() {
        Set<Vehicle> mockVehicles = new HashSet<>();

        Car car1 = new Car("car1", "Car For Sale 1", 1_000D, Year.of(2000), CarType.SEDAN, 3);
        mockVehicles.add(car1);

        Car car2 = new Car("car2", "Car For Sale 2", 20_000D, Year.of(2015), CarType.SUV, 5);
        mockVehicles.add(car2);

        Car car3 = new Car("car3", "Car For Sale 3", 5_000D, Year.of(2007), CarType.TRUCK, 5);
        mockVehicles.add(car3);

        Motorcycle motorcycle1 = new Motorcycle("motorcycle1", "Motorcycle For Sale 1", 5_000D, Year.of(2013), false);
        mockVehicles.add(motorcycle1);

        Motorcycle motorcycle2 = new Motorcycle("motorcycle2", "Motorcycle For Sale 2", 3_000D, Year.of(2010), false);
        mockVehicles.add(motorcycle2);

        Motorcycle motorcycle3 = new Motorcycle("motorcycle3", "Motorcycle For Sale 3", 12_000D, Year.of(2015), true);
        mockVehicles.add(motorcycle3);

        vehicles = Collections.unmodifiableSet(mockVehicles);
    }

    @Override
    public Set<Vehicle> loadAllVehicles() {
        return Collections.unmodifiableSet(vehicles);
    }

}
