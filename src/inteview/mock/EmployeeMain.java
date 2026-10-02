package inteview.mock;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeMain {
   public static void main(String[] args) {

       List<Employee> employeeList = Arrays.asList(
               new Employee("ankit","kumar","cse"),
               new Employee("akash",null,"it"),
               new Employee("vikash","gaurav","it"),
               new Employee("aditya",null,"it")
               );

     List<Employee> ans= employeeList.stream().sorted(Comparator.comparing(
                        Employee::firstName)
                        .thenComparing(Employee::lastName,
                         Comparator.nullsFirst(String::compareTo))).toList();
       System.out.println(ans);

    }
}
