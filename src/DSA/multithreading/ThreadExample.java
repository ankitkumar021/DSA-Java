package DSA.multithreading;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreadExample {
  public   static void main(String[] args) throws InterruptedException {

      Thread t1 = new Thread(() -> System.out.println("Thread t1"));
      //calling thread.start() method before setDaemon method gives
      // IllegalThreadStateException
      //t1.start();
      t1.setDaemon(true);//it won't print result on the console
      t1.start();
      int arr[] = {1, 5, 7, 5, 4, 4};

      Set<Integer> seen = new HashSet<>();
      Set<Integer> duplicates = new HashSet<>();

      for (int num : arr) {
          if (!seen.add(num)) {
              duplicates.add(num);
          }
      }

      System.out.println("Duplicate elements: " + duplicates);

     // int arr[] = {1, 5, 7, 5, 4, 4};

      Map<Integer, Integer> map = new HashMap<>();

      for (int num : arr) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }

      System.out.print("Duplicates: ");
      map.forEach((k, v) -> {
          if (v > 1) System.out.print(k + " ");
      });

      System.out.print("\nUnique: ");
      map.forEach((k, v) -> {
          if (v == 1) System.out.print(k + " ");
      });



      //abc
      //abc
      //abc


    }
}
