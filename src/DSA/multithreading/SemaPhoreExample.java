package DSA.multithreading;
//A semaphore is a synchronization tool in multithreading
//A semaphore controls access to a shared resource through the use of a counter.
// If the counter is greater than zero, then access is allowed. If it is zero, then access is denied.
//They also prevent race conditions
//	Can be Fair or Unfair
// Guarantees fairness by maintaining a queue, which ensures that no thread waits indefinitely,
// although this comes with a slight performance overhead.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaPhoreExample {
   public static void main(String[] args) throws InterruptedException {
       //addition
        Semaphore semaphore = new Semaphore(3);
        Semaphore semaphore1 = new Semaphore(3,true);
       
       ExecutorService service = Executors.newFixedThreadPool(50);
       IntStream.of(1000).forEach(i->service.execute(new Task(semaphore)));
       service.shutdown();
       service.awaitTermination(1, TimeUnit.MINUTES);


   }
   static class Task implements Runnable{
       private final Semaphore semaphore;
       public Task(Semaphore semaphore) {
           this.semaphore=semaphore;
       }

       @Override
       public void run(){
           //some processing
           try {
               semaphore.acquire();//only 3 thread can acquire at a time.
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           //semaphore.acquireUninterruptibly(2);//overloaded method

           //IO call to the slow service(acquire method is called before calling the service)
           semaphore.release();
          // semaphore.release(2);//overloaded method(number should be matching acquire)
           //rest of processing

       }
   }

//other method are :
    //tryAcquire
    //tryAcquire(timeout)
    //availablePermits
    //new Semaphore(count,fairness)


}
