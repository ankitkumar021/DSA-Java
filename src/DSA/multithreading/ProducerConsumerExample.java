package DSA.multithreading;

import java.util.LinkedList;

public class ProducerConsumerExample {
      public  static void main(String[] args) throws InterruptedException {
          Pc pc =  new Pc();
          Thread t1 = new Thread(()-> {
                  try {
                      pc.producer();
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
          });
          Thread t2 = new Thread(() ->{
                  try {
                      pc.consumer();
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
          });

          t1.start();
          t2.start();

    /*      t1.join();
          t2.join();*/
        }
    static class Pc{
      static boolean producerOver = true;
      LinkedList<Integer> list = new LinkedList<>();
      int capacity =2;

      public void producer() throws InterruptedException {
          int value=0;
          while(true){
              synchronized (this){
                  while(list.size()>=capacity){
                      System.out.println("List is full ,producer is waiting");
                      notify();
                      wait();
                  }
                  list.add(value);
                  System.out.println("Producer produce " + value);
                  value++;
                  notify();

                  if(value==capacity){
                      producerOver=false;
                  }
                  Thread.sleep(1000);
              }
          }
      }
      public void consumer() throws InterruptedException {
          while(true){
              synchronized (this){
                  while(list.size()==0){
                      System.out.println("List is empty ,consumer is waiting");
                      notify();
                      wait();
                  }
                  int value = list.removeFirst();
                  System.out.println("Consumer consume " + value);
                  notify();
                  if(value==0){
                      producerOver=true;
                  }
                  Thread.sleep(1000);
              }
          }

      }
    }
}
