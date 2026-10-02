package DSA.binarysearch;
//https://leetcode.com/problems/sqrtx/
public class Sqrt {
    public static void main(String[] args) {
        int x= 4;
        System.out.println(mySqrt(x));

    }
    public static int mySqrt(int x) {
        int s=0;
        int e=x;
        while(s<=e){
            int m = s+(e-s)/2;

            if(m*m == x){
                return m;
            }

            else if((long)m*m > (long)x){
                e = m-1;;
            }
            else{
                s = m+1;
            }

        }
        return Math.round(e);

    }
}
