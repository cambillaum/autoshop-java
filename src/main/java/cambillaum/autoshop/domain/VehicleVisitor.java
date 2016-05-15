package cambillaum.autoshop.domain;

public interface VehicleVisitor<T> {
    T visit(Car car);
    T visit(Motorcycle motorcycle);
}
