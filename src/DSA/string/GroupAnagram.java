package DSA.string;
//https://leetcode.com/problems/group-anagrams/
//klogk is sorting k here is number of char in the string +o(n) is for loop
//Total: N*Klog(K)
import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
       String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.print(groupAnagrams(str));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        //complexity: 0(n)
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] fre = new int[26];
            for(int i=0;i<s.length();i++){
                fre[s.charAt(i)-'a']++;
            }
            String key = Arrays.toString(fre);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());

    }
/*    public static List<List<String>> groupAnagrams(String[] str) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: str){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }*/

}
