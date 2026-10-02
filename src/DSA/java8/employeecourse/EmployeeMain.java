package DSA.java8.employeecourse;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //SetObject(set);
        HashMap<String, Integer> map = null;
        System.out.println(map);


        List<Employee> list = List.of(
                new Employee(1, "ankit", List.of("java", "python", "js")),
                new Employee(2, "vikash", List.of("java", "python")),
                new Employee(3, "avinash", List.of("java", "kafka"))
        );
/*        Employee e1 = new Employee(1, "ankit", List.of("java", "python", "js"));
        Employee e2 = new Employee(2, "vikash", List.of("java", "python"));
        Employee e3 = new Employee(3, "avinash", List.of("java", "kafka"));*/
/*        Map<List<String>, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(
                l -> l.courses().stream()));*/
        //  System.out.println(collect);

        map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 7);
        map.put("c", 2);

        HashMap<String, Integer> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey
                        , Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
        System.out.println(collect);



/*        Map<String, Long> result = list.stream()
                .flatMap(e -> e.courses().stream())
                .collect(Collectors
                        .groupingBy(course -> course, Collectors.counting())
                );
        System.out.println(result);*/

/*        Map<String, List<Employee>> result2 = list.stream()
                .flatMap(e -> e.courses().stream()
                        .map(course->Map.entry(course,e)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,Collectors.toList())));
        System.out.println(result2);*/
    }


/*    public static void SetObject(HashSet<Integer> set){
        set.add(100);
        set.add(200);
        set.add(200);
    }*/

}

