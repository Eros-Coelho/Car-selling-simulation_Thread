public class ListCarsByMakeRequest implements Runnable {
    private final CarRepository repository;
    private final String make;

    public ListCarsByMakeRequest(CarRepository repository, String make) {
        this.repository = repository;
        this.make = make;
    }

//    listing just the cars that match the make thee user is looking for
    @Override
    public void run() {
        System.out.println("\nSearch car by make: " + make);
        for (Car car : repository.listCarsByMake(make)) {
            System.out.println(car);
        }
    }
}
