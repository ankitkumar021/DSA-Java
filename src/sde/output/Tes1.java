package sde.output;

public class Tes1 {
    static int x = 6;
    public static void main(String [] args) {
        Tes1 p = new Tes1();
        p.doStuff(x);
        System.out.println(" main x = " + x);
    }
   public static void doStuff(int x) {
        System.out.println(" doStuff x = " + x++);
    }
}
