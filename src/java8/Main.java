package java8;

import java.util.*;
import java.util.stream.Collectors;

class Main {

    static class Employee {
        final String name;
        final int age;
        final double salary;
        final String department;

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }

    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 70000, "HR"),
                new Employee("Bob", 25, 50000, "IT"),
                new Employee("Charlie", 35, 80000, "IT"),
                new Employee("David", 28, 60000, "HR"),
                new Employee("Eve", 40, 90000, "Finance"));

        // Find the following details (for each department)
        // - age of youngest employee
        // - name of youngest employee
        // - count of employees

       Map<String, Optional<Integer>> ageMap = employees.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment
               ,Collectors.mapping(
                       Employee::getAge,Collectors.minBy(Integer::compareTo)

               )));

        ageMap.forEach((dept,age)-> System.out.println(
               dept + "->" + age.orElse(null)
       ));

        Map<String, String> nameMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment
                        ,Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Employee::getAge))
                                ,e->
                                    e.map(Employee::getName).orElse("")
                        )));
        nameMap.forEach((dept,name)->
                        System.out.println(dept + "->" + name));

        Map<String ,Long> countMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
        countMap.forEach((dept,countVal)->
                System.out.println(dept + "->" +countVal));

    }

}