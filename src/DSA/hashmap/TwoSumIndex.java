package DSA.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumIndex {
   public static void main(String[] args) {
        int[] arr ={5,1,8,1};
        int target = 6;
       System.out.println(Arrays.toString(sumIndex(arr,target)));
       //System.out.println(sumIndex(arr,target));
    }

    private static int[] sumIndex(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int currentSum = target-arr[i];
            if(map.containsKey(currentSum)){
                return new int []{map.get(currentSum),i};
            }else{
                map.put(arr[i],i);
            }
        }
        return new int[]{};
        //return list;
    }
}
