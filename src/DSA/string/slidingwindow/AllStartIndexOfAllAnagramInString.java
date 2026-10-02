package DSA.string.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

public class AllStartIndexOfAllAnagramInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        int count = p.length();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            //check whether pmap has this char and
            //count of this char int smap should be less than or equal to
            if (pmap.containsKey(ch) && smap.get(ch) <= pmap.get(ch)) {
                count--;
            }

            //when the length becomes greater than p string
            //you have slide the window
            //but before sliding it check the below
            //if the removing char is present in the pmap and its count
            //in the smap is <= pmap
            //that means this is imp charcter will be used in future
            //so count++;
            if (r - l + 1 > p.length()) {
                char leftChar = s.charAt(l);
                if (pmap.containsKey(leftChar) &&
                        smap.get(leftChar) <= pmap.get(leftChar)) {
                    count++;
                }
                smap.put(leftChar, smap.get(leftChar) - 1);
                l++;
            }
            if (count == 0) {
                list.add(l);
            }
        }
        return list;
    }

}
