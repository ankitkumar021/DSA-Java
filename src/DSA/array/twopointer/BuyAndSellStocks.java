package DSA.array.twopointer;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};//we cannot buy at 1st day as profit becomes (-ve)
        System.out.println(maxProfit(prices));//buy 2nd day and sell 5th day(6-1)
    }
    public static int maxProfit(int[] prices) {
        //using  pointer
        int left = 0;
        int right = 1;
        int mProfit =0;
        while(right < prices.length){
            //profitable
            if(prices[left] < prices[right]){//left is buy day and right is sell d
                int profit = prices[right] - prices[left];
                mProfit = Math.max(mProfit,profit);
            }
            else{//in-case previous day prices is greater than cur day{-ve} profit
                left = right;
            }
            right = right+1;
        }
        return mProfit;
    }
}
