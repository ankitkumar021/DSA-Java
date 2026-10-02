package DSA.recursion.linear;
//https://www.geeksforgeeks.org/problems/print-n-to-1-without-loop/1
public class PrintNTo1 {
    public static void main(String[] args) {
        int n = 10;
        printNto1(n);

    }

    private static void printNto1(int n) {
        if (n == 0) return;

        //even though this print the number but
        //still present in the stack waiting n-1 to finished and return and vice versa.
        System.out.print(" " + n);

        printNto1(n - 1);
    }
}
