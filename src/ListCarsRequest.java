public class ListCarsRequest implements Runnable {
    private final CarRepository repository;

    public ListCarsRequest(CarRepository repository) {
        this.repository = repository;
    }

//    method to loop through car objects and print each one's specification
    @Override
    public void run() {
        System.out.println("\nCars for Sale:");
        for (Car car : repository.listCarsForSale()) {
            System.out.println(car);
        }
    }
}