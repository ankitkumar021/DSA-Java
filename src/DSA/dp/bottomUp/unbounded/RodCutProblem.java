package DSA.dp.bottomUp.unbounded;
//matching
//val== price
//weight = length array{ if not given run a loop till size and fill it}
//W==n

//here we can add duplicate {same piece rod} into knapsack so you have consider again
public class RodCutProblem {
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));//22(take max length+start taking from min)
    }
    public static int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n+1];

        dp[0]=0;
        for(int i =1;i<=n;i++){//divide the rod length i=1,length
            for(int j=1;j<=i;j++){//make the combination and cal profit

                dp[i] = Math.max(dp[i], price[j-1] + dp[i - j]);

            }
        }
        return dp[n];

    }
}
