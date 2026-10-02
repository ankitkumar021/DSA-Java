package DSA.array.twopointer;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));//7

    }
    public static int maxProfit(int[] prices) {
        //draw x and y diagram you will understand
        //logic the cur stock prices  is greater than prev means we have profit
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){//have profit cal it
                profit +=prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}
