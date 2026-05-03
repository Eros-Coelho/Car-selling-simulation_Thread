public class TotalSalesRequest implements Runnable {
    private final CarRepository repository;

    public TotalSalesRequest(CarRepository repository) {
        this.repository = repository;
    }

//    method to get total amount of money from cars on sale
    @Override
    public void run() {
        double total = repository.getTotalValueOfCarsForSale();
        System.out.println("\nSearch total value");
        System.out.println("$" + total);
    }
}
