package DSA.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuesSubArraySumOfSizeK {
  public  static void main(String[] args) {
      int[] nums ={23,2,4,6,7};
      int k = 6;
      System.out.println(checkSubarraySum(nums,k));

    }
    //the idea to solve the problem is take every element of an array
    //add it to sum and take the modules ,
    // if modules of sum(rem) is present in the map that means sum is present
    //and take (index - map.get(rem))>=2 if yes return true.
    //if not present than put it into map as key and value should index
    //before starting the put the map with(0,-1)-> example{2,4}

    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        //2,4(take example of this)
        //when we insert the rem that time there is nothing to compare
        map.put(0,-1);//why -1 why not 0 because we want min length=2
        int prefixSum = 0;
        for(int i=0;i<nums.length;i++){

            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2){//condition length should be >=2
                    return true;
                }
            }else{
                map.put(rem,i);
            }

        }
        return false;

    }
}
