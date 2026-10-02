package DSA.dp.bottomUp.knapsackpattern;
//There is only one possible partition of this array. Partition : [6, 4], [5, 2].
//The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
//https://leetcode.com/discuss/post/1271034/count-no-of-subsets-with-given-differenc-p0vo/
//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class CountOfSubsetWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        System.out.println(countPartitions(arr, diff));//1
    }

    public static int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if ((sum + diff) % 2 != 0 || diff > sum) {//not possible case
            return 0;
        }
        int targetSum = (sum - diff) / 2;

        int[][] dp = new int[n + 1][targetSum + 1];

        dp[0][0] = 1;//subset sum =0

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= targetSum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][targetSum];
    }

}
