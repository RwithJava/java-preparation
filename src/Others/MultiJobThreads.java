package Others;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiJobThreads {

    public static void main(String[] args) {
        int numberOfThreads = 5;
        try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads)) {

            List<Future<String>> futures = new ArrayList<>();
            for (int i = 0; i < numberOfThreads; i++) {
                Callable<String> callableTask = createCallableTask(i);
                Future<String> future = executorService.submit(callableTask);
                futures.add(future);
            }

            // Collect the results from the futures
            for (Future<String> future : futures) {
                try {
                    String result = future.get(); // This call is blocking
                    System.out.println(result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executorService.shutdown();
        }
    }

    private static Callable<String> createCallableTask(int index) {
        return () -> {
            // Simulate some work with thread sleep
            Thread.sleep(1000);
            return "Result from thread " + index;
        };
    }
}
