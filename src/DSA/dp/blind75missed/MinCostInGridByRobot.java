package DSA.dp.blind75missed;

public class MinCostInGridByRobot {
   public static void main(String[] args) {
       int[] startPos = {1, 0};
       int[] homePos = {2, 3};
       int[] rowCosts = {5, 4, 3};
       int[] colCosts = {8, 2, 6, 7};
       System.out.println(minCost(startPos,homePos,rowCosts,colCosts));
//18

    }
    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        //the logic here is always try to go toward the home  don't go away
        //when house at the down pos and you are at upside go toward down {r+1,col+1}
        //else vice versa when you are at the down pos  and go up {r-1,col-1}

        int r1 = startPos[0];
        int c1= startPos[1];

        int r2 = homePos[0];
        int c2 = homePos[1];

        int sum =0;

        //move in rows
        if(r2>r1){
            //moving down
            for(int r=r1+1;r<=r2;r++){
                sum += rowCosts[r];
            }
        }else{
            //moving up
            for(int r=r1-1;r>=r2;r--){
                sum += rowCosts[r];
            }
        }

        //move in column
        if(c2>c1){
            //moving right
            for(int c=c1+1;c<=c2;c++){
                sum += colCosts[c];
            }
        }else{
            //moving left
            for(int c = c1-1;c>=c2;c--){
                sum += colCosts[c];
            }
        }

        return sum;

    }
}
