package DSA.dp.blind75missed;

//https://leetcode.com/problems/unique-paths/
public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));//28
    }

    public static int uniquePaths(int m, int n) {
        //dp
        return countPaths(m - 1, n - 1, new int[m][n]); //(2,6) since 0th based indexing
    }

    public static int countPaths(int row, int col, int[][] memo) {
        if (row == 0 || col == 0) return 1;//there are only 1 to reach to the end
        if (memo[row][col] != 0) {//when already calculate while going back to (0,0) return this
            return memo[row][col];
        }
        //here we are going from end to start since start to end is vice versa
        //so every time either we can go row wise or column wise right as per question
        //so decrease 1 from both.
        memo[row][col] = countPaths(row - 1, col, memo) + countPaths(row, col - 1, memo);
        return memo[row][col];

    }
}
/*
public int uniquePaths(int m, int n) {
    //Gives TLE
    return countPaths(m-1,n-1); //since 0th based indexing

}
public int countPaths(int row ,int col){
    if(row == 0 || col == 0)return 1;

    return countPaths(row-1,col) + countPaths(row,col-1);

}*/
