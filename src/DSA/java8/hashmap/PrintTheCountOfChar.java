package DSA.java8.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintTheCountOfChar {
   public static void main(String[] args) {
       String s = "1Java is Cool";
       HashMap<Character, Integer> map = new HashMap<>();
       Map<Character, Long> mapCount =  s.chars().mapToObj(c -> (char)c)
               .filter(Character::isLetter)
               .map(Character::toLowerCase)
               .collect(Collectors.groupingBy(Function.identity()
                       ,Collectors.counting()));
       System.out.print(mapCount);

    }
}
