package DSA.recursion.linear;
//https://www.geeksforgeeks.org/problems/palindrome0746/1

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 1221;
        System.out.println(isPalindrome(n));
    }
    private static boolean isPalindrome(int n) {
        n = Math.abs(n);//in-case number is negative
        String s = String.valueOf(n);
        int left = 0;
        int right = s.length()-1;
        return checkPalindrome(s,left,right);
    }
    private static boolean checkPalindrome(String s, int left, int right) {
        if(left>=right) return true;
        if(s.charAt(left)!= s.charAt(right)){
            return false;
        }
        return checkPalindrome(s,left+1,right-1);
    }
}
