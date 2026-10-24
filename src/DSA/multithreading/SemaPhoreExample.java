package DSA.multithreading;
//A semaphore is a synchronization tool in multithreading
//A semaphore controls access to a shared resource through the use of a counter.
// If the counter is greater than zero, then access is allowed.
// If it is zero, then access is denied.
//They also prevent race conditions
//	Can be Fair or Unfair
// Guarantees fairness by maintaining a queue(FIFO),
// which ensures that no thread waits indefinitely,
// although this comes with a slight performance overhead.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SemaPhoreExample {

    //add the counter
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    //allow 3 thread at once
    static Semaphore semaphore = new Semaphore(3);
    Semaphore semaphore1 = new Semaphore(3,true);

   public static void main(String[] args) throws InterruptedException {

       //allow 3 thread at once (t1,t2,t3)->from t4 to t50 will wait
       //after t1 release t4 will acquire ....
       ExecutorService service = Executors.newFixedThreadPool(50);
       IntStream.of(1000).forEach(i->service.execute(new Task(semaphore)));
       //will not accept the new task,but it doesn't wait for existing task to finish
       service.shutdown();
       //ensure all the task is completed till then main thread is blocked
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
               //1:acquire
               //2:increase the counter
               //3:processing
               //4:decrease the counter

               semaphore.acquire();//only 3 thread can acquire at a time.

               int cur = atomicInteger.getAndIncrement();//thread entered the critical sec
               System.out.println(Thread.currentThread().getName() + "counter = " + cur);
               Thread.sleep(1000);

               //process

               //thread leaving
               cur  = atomicInteger.decrementAndGet();
               System.out.println(Thread.currentThread().getName() + "counter = " +cur);



           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           //semaphore.acquireUninterruptibly(2);//overloaded method

           //IO call to the slow service(acquire method is called before calling the service)
           semaphore.release();//you also use this statement in finally block
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
