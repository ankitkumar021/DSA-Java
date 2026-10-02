package DSA.string.twopointer;
//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public  static void main(String[] args) {
        // String s1 = "race a car";
        String s = "A man, a plan, a canal: Panama";
        //"amanaplanacanalpanama" is a palindrome.
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int len = s.length();

        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
