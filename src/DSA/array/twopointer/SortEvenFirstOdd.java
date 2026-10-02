package DSA.array.twopointer;

import java.util.Arrays;

public class SortEvenFirstOdd {
    public static void main(String[] args) {
      //  int[] arr = {10,2,5,7,8,20};
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        //8 12 34 90 3 9 45
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] arr) {
        int low=0;
        int high=arr.length-1;
        while(low<high){
            while(arr[low]%2 == 0){
                low++;
            }
            while(arr[high]%2 == 1){
                high--;
            }
            if(low<high){
                int temp = arr[low];
                arr[low]=arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
        }
        return arr;
    }
}
