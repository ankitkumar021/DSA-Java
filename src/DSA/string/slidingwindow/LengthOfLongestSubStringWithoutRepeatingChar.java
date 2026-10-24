package DSA.string.slidingwindow;

import java.util.HashMap;
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
/*    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int max =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.get(c)>1){//when count greater than 1 keep removing
                char ch = s.charAt(l);
                map.put(ch,map.get(ch)-1);
                l++;
            }
            max = Math.max(max,i-l+1);

        }
        return max;
    }*/
}
