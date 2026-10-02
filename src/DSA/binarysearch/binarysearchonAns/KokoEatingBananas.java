package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        // int a = 157;
        // int b = 32;
        // int ceilValue = (a + b - 1) / b;

        int s = 1;//speed initially take 1
        int e = Integer.MIN_VALUE;

        for (int p : piles) {
            e = Math.max(e, p);// piles = [3,6,7,11]->e = 11
        }
        int ans = e;//assign the ans with max speed
        while (s <= e) {
            int m = s + (e - s) / 2;//m is the speed
            if (checkPossibility(piles, h, m)) {
                ans = m;//keep track of ans
                e = m - 1;//search for min and for this go left
            } else {
                //go right with higher speed
                s = m + 1;
            }
        }
        return ans;
    }
    public static boolean checkPossibility(int[] piles, int h, int m) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + m - 1) / m;//ceil calculation
        }
        if (hours <= h) {
            return true;
        }
        return false;

    }
}
