package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinNumberOfDayToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m=3;
        int k =1;
        System.out.println(minDays(bloomDay,m,k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        //base case
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            s = Math.min(s, bloom);
            e = Math.max(e, bloom);
        }
        int ans = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (possible(bloomDay, m, k, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;

    }

    public static boolean possible(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int bouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    //m--;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }
}
