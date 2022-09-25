package ExecService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllDemo2 {
    //this class displays how to call multiple tasks with ExecutorService
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        //list of multiple callable tasks
        List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                ()-> "task #1",
                ()-> "task #2",
                ()-> "task #3",
                ()-> "task #4"
        ));

        //creating a list of future type objects
        List<Future<String>> futures = es.invokeAll(tasks);

        futures.stream().map(future -> {
            try{
                future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        }).forEach(System.out::println);

    }
}
