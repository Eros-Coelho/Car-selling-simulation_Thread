import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }

//    synchronized boolean to be thread safe and to allow me to call it as boolean in other classes
    public synchronized boolean addCar(Car car) {
        boolean added = cars.add(car);
        if (added) {
            System.out.println(car.getMake() + " added successfully!");
        }
        return added;
    }

//    method for selling cars
    public synchronized boolean sellCar(String registration) {
        for (Car car : cars) { //loops through all cars and sells only the car specified
            if (car.getRegistration().equals(registration) && car.isForSale()) {
                car.setForSale(false);
                System.out.println("Car with registration " + registration + " sold successfully!");
                return true;
            }
        }
//        inform the user if car has been sold already
        System.out.println("Car with registration " + registration + " not found or already sold.");
        return false;
    }

    public synchronized List<Car> listCarsForSale() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) { //loops through car list and prints the ones on sale
            if (car.isForSale()) {
                result.add(car);
            }
        }
        return result;
    }

    public synchronized List<Car> listCarsByMake(String make) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) { //loops through cars and lists the one that match with the specified make
            if (car.isForSale() && car.getMake().equalsIgnoreCase(make)) { //ignores case
                result.add(car);
            }
        }
        return result;
    }

//    gets the total value of all cars for sale
    public synchronized double getTotalValueOfCarsForSale() {
        double total = 0.0;
        for (Car car : cars) {
            if (car.isForSale()) {
                total += car.getPrice();
            }
        }
        return total;
    }
}