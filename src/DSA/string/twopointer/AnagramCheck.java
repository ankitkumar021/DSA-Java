package DSA.string.twopointer;

import java.util.HashMap;
//https://leetcode.com/problems/valid-anagram/description/
public class AnagramCheck {
  public static void main(String[] args) {
      String s1 = "listen";
      String s2 = "silent";
      System.out.println(isAnagram(s1,s2));
    }
    private static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> charCountMap = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            charCountMap.put(ch,charCountMap.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(charCountMap.containsKey(ch) && charCountMap.get(ch)>0){
                charCountMap.put(ch,charCountMap.get(ch)-1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
