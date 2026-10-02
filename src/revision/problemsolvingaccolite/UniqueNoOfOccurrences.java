package revision.problemsolvingaccolite;

/*Given an array of integers arr, return true if the number of occurrences of each
value in the array is unique or false otherwise.
        Example 1:Input: arr = [1,2,2,1,1,3] Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values
have the same number of occurrences.
        Example 2: Input: arr = [1,2] Output: false*/

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNoOfOccurrences {
   public static void main(String[] args) {
       int[] arr = {1,2,2,1,1,3};
       int[] arr1 = {1,2};
       System.out.println(uniqueOccurrences(arr));
       //System.out.println(uniqueOccurrences(arr1));
    }
    public static boolean uniqueOccurrences(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> uniqueSet = new HashSet<>();
        for(int num: map.values()){
            uniqueSet.add(num);
        }
       return uniqueSet.size()==map.size();

    }
}
