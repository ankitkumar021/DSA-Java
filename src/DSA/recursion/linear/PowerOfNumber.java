package DSA.recursion.linear;

//log(n)
//https://leetcode.com/problems/powx-n/description/
public class PowerOfNumber {
    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
        System.out.println(myPow(2, -4));
    }

    public static double myPow(double x, int n) {
        long exp = n;
        if (n < 0) {
            x = 1 / x;//2 ka power -2 we can write 2 base with 1/2
            exp = -exp;// since we make 1/2 now power we have make (+)ve.
        }
        return power(x, exp, 1);
    }

    public static double power(double x, long n, double ans) {
        if (n == 0) return ans;//when n reached 0 we have already our ans
//here basically we are calculating only the half part let say 2 pow 4 means 2 pow and
// if it odd we are just adding extra base to the ans.
        if (n % 2 != 0) {
            ans *= x;//in-case power is odd we have add 1 extra time
        }
        //2 ka power 4 = 2*2*2*2= 2 ka power 2 ka whole power 4/2 = 2
        return power(x * x, n / 2, ans);//in case of even we do need to add extra x
    }
}
