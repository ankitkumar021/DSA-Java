package DSA.array.prefixsum;

public class FindPivotIndexInArray {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] arr) {
        int total = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int num : arr) {
            total += num;
        }
        for (int i = 0; i < arr.length; i++) {
            rightSum = total - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;

    }

}
