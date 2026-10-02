package DSA.array.twopointer;

import java.util.Arrays;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//NOTE:since the array is sorted we can apply the 2 pointer
public class TwoSumWhenArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int k = 9;
        System.out.println(Arrays.toString(pair(arr,k)));

    }
    public static int[] pair(int[] arr,int k){
        int left=0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==k){
                return  new int[]{left,right};
            } else if (arr[left]+arr[right]>k) {
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}
