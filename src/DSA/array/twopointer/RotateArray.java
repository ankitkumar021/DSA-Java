package DSA.array.twopointer;
//https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
/*        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]*/
        rotate(arr,k);

    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length - 1;
        k = k % n;

        swap(arr, 0, n);
        swap(arr, 0, k - 1);
        swap(arr, k, n);

    }

    public static void swap(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }

    }
}
