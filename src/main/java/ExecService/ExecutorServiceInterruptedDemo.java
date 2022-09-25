package ExecService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceInterruptedDemo {
    //this program attempts to interrupt ExecutedService operation
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        //generating random numbers from IntStream and performing operations on them
        IntStream.range(1, 10).forEach((i) -> {
            es.submit(() -> {
                try{
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" task #" + i + " is completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        //shutting executor service down
        System.out.println(" Shutting down...");
        es.shutdown();//this stops our executor service to stop accepting new tasks

        //uncommenting the following code should produce an exception...an activity after executor service has shut down
        //es.submit(() -> System.out.println("This task should generate an exception after shutdonw"));

        //trying the execution of the following out
        try{
            es.awaitTermination(2, TimeUnit.SECONDS);//this is the time program waits for all threads to shut down
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdownNow();//this shuts down all tasks and return the threads awaiting execution
        }
    }
}
