package DSA.array.twopointer;

import java.util.Arrays;

public class MoveAllKToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 20, 5, 40, 60, 20};
        int k = 20;
        System.out.println(Arrays.toString(move(arr, k)));
    }

    public static int[] move(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            while (arr[high] == k) {
                high--;
            }
            if (arr[low] == k) {
                swap(arr, low, high);
            }
            low++;//why only low++ why not high-- because high-- is considered above

        }
        return arr;
    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
