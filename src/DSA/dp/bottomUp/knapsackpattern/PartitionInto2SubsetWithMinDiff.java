package DSA.dp.bottomUp.knapsackpattern;
//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
public class PartitionInto2SubsetWithMinDiff {
   public static void main(String[] args) {

    }
    public int minDifference(int arr[]) {

        int n = arr.length;
        int sumTotal = 0;
        for(int num : arr){
            sumTotal +=num;
        }
        boolean[][] dp = new boolean[n+1][sumTotal+1];

        dp[0][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sumTotal;j++){

                if(arr[i-1]<=j){

                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int mindiff = Integer.MAX_VALUE;
        for(int sum =0;sum<=sumTotal/2;sum++){
            if(dp[n][sum]){
                //total=10,sub1=4,sub2=6
                // subset1 sum is = sumTotal-sum;
                // subset2 sum is = sum
                mindiff = Math.min(mindiff,Math.abs((sumTotal-sum) -sum));
            }
        }
        return mindiff;
    }
}
