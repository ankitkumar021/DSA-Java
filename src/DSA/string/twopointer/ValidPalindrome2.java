package DSA.string.twopointer;
//https://leetcode.com/problems/valid-palindrome-ii/description/
//Given a string s, return true if
// the s can be palindrome after deleting at most one character from it.
public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = " aba";
        System.out.println(validPalindrome(s));
        String s1 = " abda";
        System.out.println(validPalindrome(s1));
    }

    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                //move l to check if valid
                //move r to check if valid
                return checkValid(s, l + 1, r) || checkValid(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    public static boolean checkValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
