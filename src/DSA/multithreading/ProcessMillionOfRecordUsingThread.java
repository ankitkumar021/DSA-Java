package DSA.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;


public class ProcessMillionOfRecordUsingThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int size = 10_000_000;
        int[] arr = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }

        //using single (main thread)

        long start = System.currentTimeMillis();
        long singleThreadSum = sumUsingSingleThread(arr);
        long end = System.currentTimeMillis();
        System.out.println("Single thread(main thread sum " + singleThreadSum);
        System.out.println("Time Taken by single thread :  " + (end - start));

        //using multithread sum

        long startMulti = System.currentTimeMillis();
        long multiThreadSum = sumUsingMultiThread(arr, 5);
        long endMulti = System.currentTimeMillis();
        System.out.println("Multi thread sum " + multiThreadSum);
        System.out.println("Time Taken by multi thread : " + (endMulti - startMulti));

        //using java stream

        long startStream = System.currentTimeMillis();
        long streamThreadSum = sumUsingStream(arr);
        long endStream = System.currentTimeMillis();
        System.out.println("Stream thread sum " + streamThreadSum);
        System.out.println("Time Taken by parallel stream : " + (endStream - startStream));

    }

    private static long sumUsingSingleThread(int[] arr) {
        long sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    private static long sumUsingMultiThread(int[] arr, int numberOfThread) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);

        List<Future<Long>> futures = new ArrayList<>();
        int chunkSize = arr.length / numberOfThread;
        for (int i = 0; i < numberOfThread; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThread - 1) ? arr.length : start + chunkSize;
            futures.add(executorService.submit(() -> {
                long partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += arr[j];
                }
                return partialSum;
            }));
        }
        long totalSum = 0;
        for (Future<Long> future : futures) {

            totalSum += future.get();
        }
        executorService.shutdown();
        return totalSum;

    }

    private static long sumUsingStream(int[] arr) {

        return IntStream.of(arr).parallel().asLongStream().sum();
    }
}
