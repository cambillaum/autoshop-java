package cambillaum.autoshop.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Year;

public class Motorcycle implements Vehicle {

    private final String id;
    private final String name;
    private final Double dollarPrice;
    private final Year modelYear;
    private final Boolean hasSidecar;

    public Motorcycle(final String id, final String name, final Double dollarPrice, final Year modelYear, final Boolean hasSidecar) {
        this.id = id;
        this.name = name;
        this.dollarPrice = dollarPrice;
        this.modelYear = modelYear;
        this.hasSidecar = hasSidecar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if(!(o instanceof Motorcycle)) {
            return false;
        }
        Motorcycle other = (Motorcycle) o;
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
        toStringBuilder.append("hasSidecar", hasSidecar);

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

    public Boolean hasSidecar() {
        return hasSidecar;
    }
}
