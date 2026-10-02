package DSA.multithreading;

import java.util.concurrent.ConcurrentHashMap;

public class SequenceThread {
   static volatile int flag1 = 1;
   ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();

   public static void main(String[] args) {
       Thread t1 = new Thread(() -> {
               for(int i=0;i<3;i++){
                   while(flag1!=1){
                       try {
                           Thread.sleep(1);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println("T1 executed");
                   flag1 = 2;
               }
       });
       Thread t2 = new Thread(() ->{
               for(int i=0;i<3;i++){
                   while(flag1!=2){
                       try {
                           Thread.sleep(1);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println("T2 executed");
                   flag1 = 3;
               }

       });

       Thread t3 = new Thread(()-> {
               for(int i=0;i<3;i++){
                   while(flag1!=3){
                       try {
                           Thread.sleep(1);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println("T3 executed");
                   flag1 = 1;
               }
       });
       t1.start();
       t2.start();
       t3.start();

    }
}
