package DSA.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelApiCall {

    private static String callServices(String serviceName){

        return serviceName;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newScheduledThreadPool(2);

        try{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
                callServices("serviceA"), executorService);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->
                callServices("serviceB"), executorService);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->
                callServices("serviceC"), executorService);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() ->
                callServices("serviceD"), executorService);

        CompletableFuture<Void> combineFuture = CompletableFuture
                .allOf(future, future1, future2, future3);

        combineFuture.thenRun(() -> {
            String res = String.join("||",
                    future.join(), future1.join(), future2.join()
                    , future2.join());
            System.out.println(res);
        }).join();

    }finally {
            executorService.shutdown();
        }
    }
}
