package DSA.string.twopointer;
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);//odd length both l and r at the same char
            int len2 = expandPalindrome(s, i, i + 1);//even length l is at i r and is i+1

            //at this we got to know the length of palindrome(len) but we need
            // to that know the start and end index of palindrome to return.
            int len = Math.max(len1, len2);

            //this line check is the current len is greater than we already have
            if (len > end - start) {
                //check start and end by putting i and len
                //let say s= "babad"
                //i=2
                //len = 3{aba}
                //in order to print aba, start should point to 1 and end should 3
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);//we want end to be included so(end+1).
    }

    //we need length to keep track the longest
    public static int expandPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            //we are expanding
            l--;
            r++;
        }
        return r - l - 1;//when i am at "b" it should return 1 (l--=-1,r++=1)

    }
}
