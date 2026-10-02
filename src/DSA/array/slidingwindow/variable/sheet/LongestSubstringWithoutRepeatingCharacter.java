package DSA.array.slidingwindow.variable.sheet;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
   public static void main(String[] args) {
       String s = "abcddabac";
       System.out.println(getLongestSubstring(s));
    }
    public static int getLongestSubstring(String s){
       int longest=0;
       int i=0,j=0;
       Set<Character> set = new HashSet<>();
       while(j<s.length()){
           if(!set.contains(s.charAt(j))){
               set.add(s.charAt(j));
               longest = Math.max(longest,set.size());
               j++;
           }else {
               set.remove(s.charAt(i));
               i++;
           }
       }
       return longest;

    }
}
