package cambillaum.autoshop.domain;

public enum CarType {

    SEDAN {
        @Override
        public <T> T accept(CarTypeVisitor<T> visitor) {
            return visitor.visitSedan();
        }
    },
    SUV {
        @Override
        public <T> T accept(CarTypeVisitor<T> visitor) {
            return visitor.visitSuv();
        }
    },
    TRUCK {
        @Override
        public <T> T accept(CarTypeVisitor<T> visitor) {
            return visitor.visitTruck();
        }
    };

    public abstract <T> T accept(CarTypeVisitor<T> visitor);

}
