package cambillaum.autoshop.domain;

public interface CarTypeVisitor<T> {
    T visitSedan();
    T visitSuv();
    T visitTruck();
}
