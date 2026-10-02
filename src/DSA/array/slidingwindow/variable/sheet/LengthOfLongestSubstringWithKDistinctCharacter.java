package DSA.array.slidingwindow.variable.sheet;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithKDistinctCharacter {
  public  static void main(String[] args) {
      String s = "aaabbccd";
      int k = 2;
      System.out.println(getLongestSubstring(s,k));
  }

    private static int getLongestSubstring(String s, int k) {
      int i=0,j=0;
      int maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        while (j<s.length()){
           char ch = s.charAt(j);
           map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()<=k){
                maxLen = Math.max(maxLen,j-i+1);
            }
           if(map.size()>k){
               map.put(s.charAt(i),map.get(s.charAt(i))-1);
               if(map.get(s.charAt(i)) == 0){
                   map.remove(s.charAt(i));
               }
               i++;
           }
           j++;
        }
        return maxLen;
    }
}
