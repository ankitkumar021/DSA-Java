package DSA.string.slidingwindow;
//https://leetcode.com/problems/minimum-window-substring/description/
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
       // System.out.println(getMinimumWindowSubstring(s, t));
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        //base case
        if(s.length() < t.length()){
            return "";
        }
        String res="";
        Map<Character,Integer> tmap = new HashMap<>();
        //for comparing purpose
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        //while comparing if any char count become 0 than dec the count value aslo
        int count = tmap.size();

        int i=0;
        int j=0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        //if arr[j] is present in tmap dec the count and j++
        //check the count and dec its value also and if = 0
        //dec the count by 1
        //there is scenario when we dec the count of char let 2->1->0>-1
        //when it reaches -1 meaning there is extra t comes

        //if not present moves ahead

        while(j<s.length()){
            char ch = s.charAt(j);
            if(tmap.containsKey(ch)){
                tmap.put(ch,tmap.get(ch)-1);
                if(tmap.get(ch)==0){
                    count--;
                }
            }
            while(count == 0){
                if(j-i+1<minLen){
                    minLen = j-i+1;
                    startIndex = i;
                }
                //slide
                char leftChar = s.charAt(i);
                //before removing check in the map
                //if present increase the value in the map
                //as it will help in future
                if(tmap.containsKey(leftChar)){
                    tmap.put(leftChar,tmap.get(leftChar)+1);
                    if(tmap.get(leftChar)>0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return minLen==Integer.MAX_VALUE? "" : s.substring(startIndex,startIndex+minLen);

    }
/*    private static String getMinimumWindowSubstring(String s, String t) {
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Number of unique characters required to match
        int required  = map.size();
        Map<Character,Integer> windowMap = new HashMap<>();
        // Tracks how many characters in current window match required frequency
        int formed = 0;
        // Minimum window length and starting index
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            if(map.containsKey(c) && map.get(c).intValue() == windowMap.get(c).intValue()){
                formed++;
            }
            // Try shrinking the window if all target characters matched
            while(i<=j && required == formed){
                if((j-i+1)<minLen){
                    minLen = j-i+1;
                    minLeft = i;
                }
                char leftChar = s.charAt(i);
                windowMap.put(leftChar,windowMap.get(leftChar)-1);
                if(map.containsKey(leftChar) && windowMap.get(leftChar)< map.get(leftChar)){
                    formed--;
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" :s.substring(minLeft,minLeft+minLen);
    }*/

}
