package DSA.string.slidingwindow;

import java.util.HashSet;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LengthOfLongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    private static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        HashSet<Character> set = new HashSet<>();
        int longest = 0;

        while (r<s.length()) {
            char c = s.charAt(r);
            if (!set.contains(c)) {
                set.add(c);
                longest = Math.max(longest, set.size());
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return longest;

    }
}
