package cambillaum.autoshop.service;

import cambillaum.autoshop.domain.*;
import cambillaum.autoshop.dto.*;
import cambillaum.autoshop.store.VehiclesStore;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VehiclesPageServiceImpl implements VehiclesPageService {

    private final VehiclesStore vehiclesStore;

    public VehiclesPageServiceImpl(final VehiclesStore vehiclesStore) {
        this.vehiclesStore = vehiclesStore;
    }

    @Override
    public VehiclesPageDTO loadVehiclesPage(Integer numberOfVehiclesPerPage, Integer offset) {
        Set<Vehicle> allVehicles = vehiclesStore.loadAllVehicles();

        Integer totalNumberOfVehicles = allVehicles.size();

        List<VehicleCategoryWithNumberDTO> numberOfVehiclesByCategory = extractNumberOfVehiclesByCategory(allVehicles);

        List<Vehicle> allVehiclesByAscendingPriceAndId = sortByAscendingPriceAndId(allVehicles);
        List<Vehicle> vehiclesOnPage = filterVehiclesOnPage(allVehiclesByAscendingPriceAndId, numberOfVehiclesPerPage, offset);
        List<VehicleDTO> vehiclesInPage = transformToDTOs(vehiclesOnPage);


        return new VehiclesPageDTO(totalNumberOfVehicles, numberOfVehiclesByCategory, vehiclesInPage);
    }

    private List<VehicleCategoryWithNumberDTO> extractNumberOfVehiclesByCategory(Set<Vehicle> vehicles) {
        Map<String, List<Vehicle>> categorizedVehicles = vehicles.stream().collect(Collectors.groupingBy(vehicle -> {
            return vehicle.accept(new VehicleVisitor<String>() {
                @Override
                public String visit(Car car) {
                    return car.type().accept(new CarTypeVisitor<String>() {
                        @Override
                        public String visitSedan() {
                            return "Sedan";
                        }
                        @Override
                        public String visitSuv() {
                            return "SUV";
                        }
                        @Override
                        public String visitTruck() {
                            return "Truck";
                        }
                    });
                }
                @Override
                public String visit(Motorcycle motorcycle) {
                    return "Motorcycle";
                }
            });
        }));

        List<VehicleCategoryWithNumberDTO> categoriesWithNumbers = categorizedVehicles.entrySet().stream().map(entry -> {
            String category = entry.getKey();
            List<Vehicle> vehiclesInCategory = entry.getValue();
            return new VehicleCategoryWithNumberDTO(category, vehiclesInCategory.size());
        }).collect(Collectors.toList());

        return categoriesWithNumbers.stream().sorted((category1, category2) -> {
            Integer numbersComparison = category1.numberOfVehicles().compareTo(category2.numberOfVehicles());
            if(numbersComparison != 0) {
                return numbersComparison;
            }
            return category1.category().compareTo(category2.category());
        }).collect(Collectors.toList());
    }

    private List<Vehicle> sortByAscendingPriceAndId(Set<Vehicle> vehicles) {
        Comparator<Vehicle> ascendingPriceComparator = (vehicle1, vehicle2) -> {
            Integer priceComparison = vehicle1.dollarPrice().compareTo(vehicle2.dollarPrice());
            if (priceComparison != 0) {
                return priceComparison;
            }
            return vehicle1.id().compareTo(vehicle2.id());
        };

        return vehicles.stream().sorted(ascendingPriceComparator).collect(Collectors.toList());
    }

    private List<Vehicle> filterVehiclesOnPage(List<Vehicle> vehicles, Integer numberOfVehiclesPerPage, Integer offset) {
        return vehicles.stream().skip(offset).limit(numberOfVehiclesPerPage).collect(Collectors.toList());
    }

    private List<VehicleDTO> transformToDTOs(List<Vehicle> vehicles) {
        return vehicles.stream().map(vehicle -> {
            return vehicle.accept(new VehicleVisitor<VehicleDTO>() {
                @Override
                public VehicleDTO visit(Car car) {
                    return new CarDTO(car.id(), car.name(), car.dollarPrice(), car.modelYear().getValue(), car.type().name(), car.doorsNumber());
                }
                @Override
                public VehicleDTO visit(Motorcycle motorcycle) {
                    return new MotorcycleDTO(motorcycle.id(), motorcycle.name(), motorcycle.dollarPrice(), motorcycle.modelYear().getValue(), motorcycle.hasSidecar());
                }
            });
        }).collect(Collectors.toList());
    }

}
