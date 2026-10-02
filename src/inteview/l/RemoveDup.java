package inteview.l;

import java.util.*;

public class RemoveDup {
  public   static void main(String[] args) {
/*      List<Employee> list1 = Arrays.asList(new Employee(40,"a",100),
             new Employee(30,"ankit",10.0) );*/

      Employee e5 = new Employee(30,"ankit",10.0);
      Employee e1 = new Employee(10,"ankit",10.0);
      Employee e4 = new Employee(10,"ankit",10.0);
      Employee e2 = new Employee(20,"ankit",10.0);
      Employee e3 = new Employee(30,"ankit",10.0);


      List<Employee> list = List.of(e5,e1,e4,e2,e3);


      List<Employee> ans = list.stream().distinct()
              .sorted(Comparator.comparingInt(Employee::id)).toList();
      System.out.println(ans);


    }
}
