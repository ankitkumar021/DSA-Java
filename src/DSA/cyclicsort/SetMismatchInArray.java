package DSA.cyclicsort;

import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/description/
//    Find the number
//    that occurs twice and the number that is missing and return
//    them in the form of an array.
public class SetMismatchInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int current_index = nums[i]-1;
            if(nums[i]!=nums[current_index]){
                swap(nums,i,current_index);
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!= j+1){
                return new int[] {nums[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }
    public static void swap(int[] nums,int i,int current_index){
        int temp = nums[i];
        nums[i] = nums[current_index];
        nums[current_index] = temp;
    }
}
