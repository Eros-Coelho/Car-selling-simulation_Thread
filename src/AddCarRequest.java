public class AddCarRequest implements Runnable {
    private final CarRepository repository;
    private final Car car;

    public AddCarRequest(CarRepository repository, Car car) {
        this.repository = repository;
        this.car = car;
    }

//    method to add car to the database
    @Override
    public void run() {
        repository.addCar(car);
    }
}
