package cambillaum.autoshop.domain;

import java.time.Year;

public interface Vehicle {

    String id();
    String name();
    Double dollarPrice();
    Year modelYear();

}
