package DSA.recursion.linear;

public class Print1ToN {
    public static void main(String[] args) {
        int n = 5;
        printTillN(n);//n=5 is called from main method

    }

    private static void printTillN(int n) {
        if(n==0) return;

        printTillN(n-1);
        System.out.println(n);

    }
}
