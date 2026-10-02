package sde.stringoutput;

public class S1 {
   public static void main(String[] args) {
       String s1= "sanjay";
       String s2= "jain";

       String s3= "sanjayjain";
      // s1 = s1.concat(s2);//concat method creates a new string obj out the pool
       s1 = s1.concat(s2).intern();//using intern() it will refer the same obj in poll

       System.out.println((s1 == s3));



   }
}
