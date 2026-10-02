package DSA.array.twopointer;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,0};
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] arr) {
        int low =0;
        int high = arr.length-1;
        while(low<high){
            while(arr[low]==0 && low<high){
                low++;
            }
            while(arr[high]==1 && high>low){
                high--;
            }
            if(low<high){
                int temp = arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
            }
        }
        return arr;
    }
}

/*
we can also solve using if condition inside while

int left=0;
int right = arr.length-1;
        while(left<right){
        if(arr[left]==0){
left++;
        }else if(arr[right]==1){
right--;
        }
int temp = arr[left];
arr[left]=arr[right];
arr[right]=temp;
        }*/
