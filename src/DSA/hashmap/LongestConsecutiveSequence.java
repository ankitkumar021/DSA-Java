package DSA.hashmap;

import java.util.HashSet;
//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int maxlen = 0;
        //don't use for loop else we have to write another for loop for negative case also,
        // so use for-each loop it will take care negative automatically

        for(int num:set){
            int curlen=0;
            int currentNumber = 0;
            if(!set.contains(num-1)){//check if there is prev consecutive
                currentNumber = num;//if not means this is the start num
                curlen = 1;//starts of len

                //now check for consecutive next of currentNum
                while(set.contains(currentNumber+1)){
                    currentNumber +=1;
                    curlen +=1;
                }
                maxlen = Math.max(maxlen,curlen);
            }
        }
        return maxlen;
    }
}
