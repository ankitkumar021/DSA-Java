package DSA.java8.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapSorting {
   public static void main(String[] args) {

       HashMap<String,Integer> map = new HashMap<>();

       map.put("A",4);
       map.put("B",1);
       map.put("D",7);
       map.put("C",2);

     Map<String,Integer> sortedMapBasedOnValue =  map.entrySet().stream()
               .sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (oldValue,newValue)->oldValue,
                       LinkedHashMap::new
               ));
       System.out.println("Natural Sorting by value" + sortedMapBasedOnValue);



    Map<String,Integer> reverseSortedMap = map.entrySet()
               .stream()
               .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (a,b)->a,
                       LinkedHashMap::new
               ));
       System.out.println("Reversed order Sorting by value " + reverseSortedMap);

       Map<String,Integer> sortedMapBasedOnKey =  map.entrySet().stream()
               .sorted(Map.Entry.<String,Integer>comparingByKey().reversed())
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (oldValue,newValue)->oldValue,
                       LinkedHashMap::new

               ));

       System.out.println("Reversed Sorting by key " + sortedMapBasedOnKey);


    }
}
