package DSA.binarysearch.binarysearchonAns;
//https://www.geeksforgeeks.org/problems/aggressive-cows/1
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(arr, k));
    }

    public static int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int s = 1;//s,m,e is basically the gap of cow
        int e = arr[n - 1] - arr[0];
        int ans = 0;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (isCowPlaced(arr, k, m)) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }

    public static boolean isCowPlaced(int[] stalls, int k, int m) {
        int count = 1;//we can go till k
        int last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {

            if ((stalls[i] - last >= m)) {//we are keep checking the gap
                count++;
                last = stalls[i];
            }

        }
        return count >= k;
    }

}
