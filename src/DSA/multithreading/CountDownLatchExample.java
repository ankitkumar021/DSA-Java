package DSA.multithreading;
//A CountDownLatch is a synchronization utility in Java's java.util.concurrent package
// that allows one or more threads to wait until a specific set of operations performed
//in other threads completes
//Startup sequences: Waiting for multiple services (DB, Cache, Auth) to initialize
//before the app starts. Data Aggregation: Waiting for multiple parallel API calls to finish
//before merging results.
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
   public static void main(String[] args) throws InterruptedException {
       CountDownLatch countDownLatch = new CountDownLatch(3);
/*       ExecutorService service = Executors.newFixedThreadPool(4);

       service.submit(new Worker(countDownLatch));
       service.submit(new Worker(countDownLatch));
       service.submit(new Worker(countDownLatch));*/

       Worker first = new Worker(1000,countDownLatch,"WORKER-1");
       Worker second = new Worker(1000,countDownLatch,"WORKER-2");
       Worker third = new Worker(1000,countDownLatch,"WORKER-3");

       first.start();
       second.start();
       third.start();

       countDownLatch.await();//wait for all the thread to finish.

       System.out.println(Thread.currentThread().getName() + " has finished");


    }
}
class Worker extends Thread{

  private  int delay;
  private CountDownLatch countDownLatch;

  public Worker(int delay, CountDownLatch countDownLatch,String name){
      super(name);
      this.delay=delay;
      this.countDownLatch=countDownLatch;
  }

  @Override
  public void run(){
      try {
          Thread.sleep(delay);
          countDownLatch.countDown();
          System.out.println(Thread.currentThread().getName());
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }
}
