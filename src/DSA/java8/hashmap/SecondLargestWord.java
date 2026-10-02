package DSA.java8.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class SecondLargestWord {
    public static void main(String[] args) {
        String str = "hi i am from  delhi capital of india";

        //this solution handle only 1 element let say you have 2 string having same length
        String result = Arrays.stream(str.split("\s+"))
                .distinct()
                .sorted((a,b) -> Integer.compare(b.length(),a.length()))
                //.sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .get();
                //.orElse("");

        System.out.println("second largest word " + result);


        //handle 2 string

     List<String> secondLargest=  Arrays.stream(str.split("\s+"))
                .collect(Collectors.groupingBy(String::length, TreeMap::new,Collectors.toList()))
                .descendingMap()
                .values()
                .stream()
                .skip(1)
                .findFirst()
                .orElse(Collections.emptyList());

        System.out.println(secondLargest);


    }
}
