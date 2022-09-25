package ExecService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllDemo {
    //this class attempts to use ExecutorService for multiple operations
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        //creating a list of callable tasks
        List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                ()-> "task #1",
                ()-> "task #2",
                ()-> "task #3"
        ));

        //list of all future actions to be taken
        List<Future<String>> futures = es.invokeAll(tasks);

        futures.stream().map(future -> {
            try{
                future.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        }).forEach(System.out::println);
    }
}
