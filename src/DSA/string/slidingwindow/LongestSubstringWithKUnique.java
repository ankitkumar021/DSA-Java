package DSA.string.slidingwindow;

import java.util.HashMap;

//https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
public class LongestSubstringWithKUnique {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
//return k character{meaning character can be repeated but k diff character}  longest substring
    public static int longestKSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;//for gfg taken = -1;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                l++;
            }
            if (map.size() == k) {
                longest = Math.max(longest, r - l + 1);
            }

        }
        return longest;
    }
}
