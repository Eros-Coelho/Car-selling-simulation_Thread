import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Future;

public class CarServer {

    private final CarRepository repository;
    private final Semaphore semaphore;
    private final ExecutorService threadPool;
    private final Object printLock = new Object();

    public CarServer(CarRepository repository){
        this.repository = repository;
        this.semaphore = new Semaphore(50); //only allows 50 clients at a time
        this.threadPool = Executors.newFixedThreadPool(50);
    }

    public void handleRequest(Runnable request) {
        try {
//           sends request to executorservice to be executed by one of the threads
            Future<?> future = threadPool.submit(() -> {
                try {
//                    acquire permission and try and do the request
                    semaphore.acquire();
                    request.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
//                    release permission
                    semaphore.release();
                }
            });
//            waits for the task to complete before moving on
            future.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    mehtod to shutdown threadpool once the program is finished
    public void shutdown(){
        threadPool.shutdown();
    }
}
