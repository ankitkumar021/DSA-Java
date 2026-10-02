package DSA.array.twopointer;
//https://leetcode.com/problems/move-zeroes/description/
import java.util.Arrays;

public class Move0toEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 20};
        System.out.println(Arrays.toString(move(arr)));
    }

    private static int[] move(int[] arr) {
        int j = 0;//keeps track 0
        //i will check if 0 or non-zero,if non-zero swap it
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}

/*
int j=0;
        for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
        //avoid swapping the same index
        if(i!=j){
int temp=nums[i];
nums[i]=nums[j];
nums[j]=temp;
                }
j++;
        }
        } */
