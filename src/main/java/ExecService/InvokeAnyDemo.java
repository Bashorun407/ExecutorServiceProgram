package ExecService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyDemo {
    //this class uses ExecutorService class to invoke any task from a list
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task #1";
                },

                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task #2";
                },

                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task #3";
                }
        ));

        String result = es.invokeAny(tasks);

        System.out.println(result);
    }
}
