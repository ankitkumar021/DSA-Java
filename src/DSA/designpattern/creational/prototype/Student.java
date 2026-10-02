package DSA.designpattern.creational.prototype;

public class Student implements Prototype {
    int age;
    private int rollNum;
    String name;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", rollNum=" + rollNum +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(int age, int rollNum, String name) {
        this.age = age;
        this.rollNum = rollNum;
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new Student(age,rollNum,name);
    }
}
