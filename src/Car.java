public class Car {
    private String registration;
    private String make;
    private double price;
    private int mileage;
    private boolean forSale;

    public Car(String registration, String make, double price, int mileage, boolean forSale) {
        this.registration = registration;
        this.make = make;
        this.price = price;
        this.mileage = mileage;
        this.forSale = forSale;
    }

//    getters for car
    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

//    overriden tostring method
    @Override
    public String toString() {
        return "[registration = " + registration +
                ", make = " + make +
                ", price = " + price +
                ", mileage = " + mileage +
                ", forSale = " + forSale + "]";
    }
}
