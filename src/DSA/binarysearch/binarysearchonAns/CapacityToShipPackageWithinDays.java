package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackageWithinDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));

    }

    public static int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;
        for (int w : weights) {
            s = Math.max(s, w);
            e += w;//is the total capacity it can hold
        }
        int ans = 0;
        while (s <= e) {
            int m = s + (e - s) / 2;//mid capacity
            if (checkPossibilty(weights, days, m)) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }

    public static boolean checkPossibilty(int[] weights, int days, int m) {
        int sum = 0;
        int day = 1;
        for (int w : weights) {
            if (sum + w > m) {
                day++;//increase the day to next day
                sum = w; //assign the weight to cur weight
            } else {
                sum += w;//keep adding
            }
        }
        return day <= days;
    }
}
