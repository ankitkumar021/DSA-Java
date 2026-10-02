package DSA.designpattern.creational.prototype;
//this is used when we have to make copy /clone from existing Object
//1. Object creation is expensive or time-consuming
public class ProtoTypeMain {
   public static void main(String[] args) {
      // Student s = new Student(25,22,"ankit");

/*       //creating clone obj
       Student cloneObj= new Student();
       cloneObj.age = s.age;
       cloneObj.name=s.name;
       cloneObj.rollNum=s.rollNum;

       //problems
       //1:problem as rollNum is private{since private is accessible within the class}
       //2:client i.e main method { has to copy all the field from line number 9 to 11}
       //lets it has 100 field and out 100 you have copy only 98.
       // how will you get to know which field you have copy and what you have leave

       //solution
       //cloning responsibility should not be client ,
       it should be class itself {student}*/

       Student s = new Student(25,22,"ankit");

       Student cloneObj = (Student) s.clone();
       System.out.println(cloneObj);

    }

}
