import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        creating objects for CarRepository and CarServer
        CarRepository repository = new CarRepository(new ArrayList<>());
        CarServer server = new CarServer(repository);

//        adding the 15 cars
        server.handleRequest(new AddCarRequest(repository, new Car("16L1234", "Ferrari", 120000.0, 1000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("01LH1234", "Ford Fiesta", 1000.0, 1000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("02D1234", "Ford Focus", 11000.0, 2000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("03WW1234", "Ford Mondeo", 12000.0, 3000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("04KK1234", "Ford Kuga", 13000.0, 4000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("05KK1234", "Ford Mustang", 14000.0, 5000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("06CW1234", "Ford B-Max", 15000.0, 6000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("07LS1234", "Ford C-Max", 16000.0, 7000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("08KE1234", "Ford S-Max", 17000.0, 8000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("09TC1234", "Toyota Corolla", 11000.0, 3000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("10WM1234", "Toyota Starlet", 19000.0, 10000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("11M1234", "Toyota Avensis", 20000.0, 11000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("12TY1234", "Toyota Yaris", 8000.0, 1000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("13TH1234", "Toyota Hi-Lux", 25000.0, 7000, true)));
        server.handleRequest(new AddCarRequest(repository, new Car("15CE1234", "Mitsubishi Lancer", 24000.0, 15000, true)));

//        waits for all cars to be added
        Thread.sleep(500);

//        requests for specific actions in the server
        server.handleRequest(new ListCarsRequest(repository));
        server.handleRequest(new ListCarsByMakeRequest(repository, "Ford Mustang"));
        server.handleRequest(new TotalSalesRequest(repository));
        server.handleRequest(new SellCarRequest(repository, "15CE1234"));

//        again give the program time to finish all tasks
        Thread.sleep(500);

//        print car list again, then add a new one
        server.handleRequest(new ListCarsRequest(repository));
        server.handleRequest(new AddCarRequest(repository, new Car("20D5555", "BMW", 35000, 12000, true)));

//        wait again
        Thread.sleep(500);

//        final display
        server.handleRequest(new ListCarsRequest(repository));
        server.handleRequest(new TotalSalesRequest(repository));

//        wait for all the threads to finish, then shutdown the threadpool
        Thread.sleep(1000);
        server.shutdown();
    }
}