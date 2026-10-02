package DSA.recursion.divideAndConquer;
//https://leetcode.com/problems/binary-search/
//log(n)
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target=5;
        System.out.println(search(arr,target));
    }
    private static int search(int[] arr, int target) {
        int low = 0;
        int high=arr.length-1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                low = mid+1;//search in the right side
            }else{
                high = mid-1;//search in the left side
            }
        }
        return -1;
    }
}
/*

public int search(int[] nums, int target) {
    //using recursion
    int low=0;
    int high=nums.length-1;
    return searchUsingRecursion(nums,target,low,high);
}
public int searchUsingRecursion(int[]nums,int target,int low,int high){
    //base case
    if(low>high)return -1;

    int mid = low+(high-low)/2;
    if(nums[mid]==target){
        return mid;
    }
    else if(nums[mid]<target){
        return searchUsingRecursion(nums,target,mid+1,high);
    }

    return searchUsingRecursion(nums,target,low,mid-1);

}*/
