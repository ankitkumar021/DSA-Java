package DSA.java8.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Using Java 8, Given a map of master slave like A->J,B->J,C->J,D->K,E->L,J->J,K->K.
//Create an output in the format of map of Slave
//and list of master associated with it so if we consider J
//it should have A B C J associated
public class MasterSlave {
  public  static void main(String[] args) {
      Map<String,String> map = new HashMap<>();

      map.put("A","j");
      map.put("B","j");
      map.put("C","j");
      map.put("D","k");
      map.put("E","l");
      map.put("J","j");
      map.put("k","k");

   Map<String, List<String>> result =  map.entrySet()
              .stream()
              .collect(Collectors.groupingBy(Map.Entry::getValue,
                      Collectors.mapping(Map.Entry::getKey,Collectors.toList())));

      System.out.println(result);
    }
}
