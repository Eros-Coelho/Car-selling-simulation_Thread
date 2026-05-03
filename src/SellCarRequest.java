public class SellCarRequest implements Runnable {
    private final CarRepository repository;
    private final String registration;

    public SellCarRequest(CarRepository repository, String registration) {
        this.repository = repository;
        this.registration = registration;
    }

//    method to sell car from database
    @Override
    public void run() {
        repository.sellCar(registration);
    }
}
