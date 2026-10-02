package DSA.string.twopointer;
//https://leetcode.com/problems/palindromic-substrings/
public class NumberOfPalindromicSubString {
    public static int count = 0;

    public static void main(String[] args) {
        String s = "aaa";//6
        System.out.println(countPalindromicSubstring(s));
    }

    public static int countPalindromicSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);//odd length,we can also store in variable but global is fine
            expand(s, i, i + 1);//even length
        }
        return count;
    }

    public static void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
    }
}
