package DSA.binarysearch;
//https://leetcode.com/problems/find-peak-element/description/
public class FindPivotElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int m = s+(e-s)/2;
            if(nums[m] > nums[m+1]){
                e=m;//this ensure that we are going from to lef side
            }
            else{
                s=m+1;//if not side right side
            }
        }
        return s;//e return any

    }
}
