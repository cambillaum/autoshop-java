package cambillaum.autoshop.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Year;

public class Car implements Vehicle {

    private final String id;
    private final String name;
    private final Double dollarPrice;
    private final Year modelYear;
    private final CarType type;
    private final Integer doorsNumber;

    public Car(final String id, final String name, final Double dollarPrice, final Year modelYear, final CarType type, final Integer doorsNumber) {
        this.id = id;
        this.name = name;
        this.dollarPrice = dollarPrice;
        this.modelYear = modelYear;
        this.type = type;
        this.doorsNumber = doorsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car other = (Car) o;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(id, other.id);

        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(id);

        return hashCodeBuilder.toHashCode();
    }

    @Override
    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toStringBuilder.append("id", id);
        toStringBuilder.append("name", name);
        toStringBuilder.append("dollarPrice", dollarPrice);
        toStringBuilder.append("modelYear", modelYear);
        toStringBuilder.append("carType", type);
        toStringBuilder.append("doorsNumber", doorsNumber);
        return toStringBuilder.toString();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Double dollarPrice() {
        return dollarPrice;
    }

    @Override
    public Year modelYear() {
        return modelYear;
    }

    public CarType type() {
        return this.type;
    }

    public Integer doorsNumber() {
        return doorsNumber;
    }
}
