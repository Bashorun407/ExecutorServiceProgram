package ExecService;

import java.util.concurrent.*;

public class CallableDemo {
    //this class demonstrates some of the attributes/methods/uses of the ExecutorService class
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //creating an object of the ExecutorService interface...from a method of Executors class
        ExecutorService executorService = Executors.newCachedThreadPool();

        //this returns a task that will be completed in the future...all things being equal
        Future<Integer> future = executorService.submit(()-> 1 + 1 );

        System.out.println(future.get(5, TimeUnit.SECONDS));
    }
}
