package sde.output;

public class Test1 {
    public static void main( String[] argv ) {
        Three t = new Three();
    }
}
 class One {
    public One() { System.out.println("first name " + 1); }
 }

 class Two extends One {
    public Two() { System.out.println("second name " + 2); }
}

  class Three extends Two {
     public Three() { System.out.print("third name " + 3); }
 }


