package DSA.dp.memoization.knapsackmemo;

public class Knapsack01 {
    public static void main(String[] args) {
        int W = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 1};
        System.out.println(knapsack(W,val,wt));//output=3

    }
    public static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;

        int[][] t = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                t[i][j] = -1;
            }
        }

        return knapRecur(W,val,wt,n,t);
    }
    //below code is recursive+memo
    public static int knapRecur(int W,int val[],int wt[],int n,int[][]t){

        //base case
        //always thinks of smallest valid input
        if(n==0 || W==0){
            return 0;
        }

        if(t[n][W] !=-1){
            return t[n][W];
        }
        int pick =0;

        //pick or not pick
        //go from last to 0
        if(wt[n-1]<=W){//check if any invidual wt is less than W
            pick = val[n-1]+knapRecur(W-wt[n-1],val,wt,n-1,t);
        }

        int notPick = knapRecur(W,val,wt,n-1,t);

        return t[n][W] = Math.max(pick,notPick);

    }
}
