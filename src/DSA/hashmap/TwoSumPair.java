package DSA.hashmap;

import java.util.HashMap;

public class TwoSumPair {
    public static void main(String[] args) {
        int[] arr ={5,1,-7,1};
        int target = 6;
        System.out.println(totalPair(arr,target));
    }

    private static int totalPair(int[] arr,int target) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            int currentSum = target-arr[i];
            if(pair.containsKey(currentSum)){
                count +=pair.get(currentSum);
            }else {
                pair.put(arr[i],pair.getOrDefault(arr[i],0)+1);
            }

        }
        return count;
    }
}
