package revision.problemsolvingaccolite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstringWithoutRepeatingCharacter {
   public static void main(String[] args) {
       String s =  "abcabcbbde";
       System.out.println(findLongest(s));

    }
    public static int findLongest(String s){
       Set<Character> set = new HashSet<>();
       List<Integer> list = new ArrayList<>();
       int j=0;
       int longest=0;
       for(int i=0;i<s.length();i++){
           if(!set.contains(s.charAt(i))){
               set.add(s.charAt(i));
               longest = Math.max(longest,set.size());
           }else{
               set.remove(s.charAt(j));
               j++;
           }
       }
       return longest;
    }
}
