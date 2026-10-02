package DSA.multithreading;
//A CyclicBarrier is a Java concurrency utility that allows a fixed number of threads
//to wait for each other at a common point (barrier) before proceeding together.
//It is "cyclic" because it can be reused after all threads are released,
//making it ideal for iterative, multi-phase parallel algorithms.
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->
                System.out.println("all parties needs to come to this points")
        );
        service.submit(new Task(cyclicBarrier));
        service.submit(new Task(cyclicBarrier));
        service.submit(new Task(cyclicBarrier));
        Thread.sleep(1000);
       // service.shutdown();
    }

    public static class Task implements Runnable {
        private final CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " passed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
