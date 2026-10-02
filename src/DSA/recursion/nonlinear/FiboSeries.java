package DSA.recursion.nonlinear;
//https://leetcode.com/problems/fibonacci-number/description/
public class FiboSeries {
   static int a = 0;
   static int b = 1;
    public static void main(String[] args) {
       // System.out.println(fib(4));
        printSeries(4);
    }
//2 power n
    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public static void printSeries(int n) {
        if (n == 0) return;
        System.out.println("series " + a);

        int c = a + b;
        a = b;
        b = c;

        printSeries(n-1);//n-1 is denoting how many number are left to print here

    }
}
