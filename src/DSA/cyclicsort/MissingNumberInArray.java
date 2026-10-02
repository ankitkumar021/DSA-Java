package DSA.cyclicsort;

//https://leetcode.com/discuss/post/2958275/cyclic-sort-important-pattern-by-sourin_-e9tr/

//https://leetcode.com/problems/missing-number/description/

//Given an array nums containing n distinct numbers in the range [0, n],
//return the only number in the range that is missing from the array.
public class MissingNumberInArray {
   public static void main(String[] args) {
/*       int[] nums ={3,0,1};
       System.out.println(missingNumber(nums));*/
       int[] nums ={0,1};
       System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        //cyclic sort can be applied here as number is in the range of[0,n]
        int i=0;
        while(i<nums.length){
            int current_index = nums[i];//curr_index and ele should be same
            if(nums[i]<nums.length && nums[i]!=nums[current_index]){
                swap(nums,i,current_index);
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return nums.length;//return the length of array
    }
    public static void swap(int[] nums,int i,int current_index){
        int temp = nums[i];
        nums[i] = nums[current_index];
        nums[current_index] = temp;
    }
}
