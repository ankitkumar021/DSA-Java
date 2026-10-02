package DSA.binarysearch;

import java.util.Arrays;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastIndexOfTargetElement {
    static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        ans[0] = checkIndexPos(nums,target,true);
        if(ans[0]!=-1){
            ans[1] = checkIndexPos(nums,target,false);
        }
        return ans;
    }
    public static int checkIndexPos(int[] nums,int target,boolean startIndex){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;

        while(s<=e){
            int m = s+(e-s)/2;

            if(nums[m] == target){
                ans = m;
                //check for start index if the ele is there on the left side
                if(startIndex){
                    e=m-1;
                }
                else{//go right check
                    s=m+1;
                }
            }
            else if(nums[m]<target){
                s=m+1;
            }
            else{
                e = m-1;
            }
        }
        return ans;

    }
}
