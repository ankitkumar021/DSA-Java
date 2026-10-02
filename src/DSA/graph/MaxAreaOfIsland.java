package DSA.graph;

public class MaxAreaOfIsland {
    private static int n;
    private static int m;
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));//6
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        n = grid.length;
        if(n==0) return maxArea;
        m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int currentArea = dfsAreaOfIsland(grid,i,j);
                    maxArea = Math.max(maxArea,currentArea);
                }
            }
        }
        return maxArea;
    }
    public static int dfsAreaOfIsland(int[][] grid,int i,int j){
        //edge case
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 0;//mark visited
        //added 1 as each cell 1 contribute to an area
        return 1+dfsAreaOfIsland(grid,i+1,j)+dfsAreaOfIsland(grid,i-1,j)
                +dfsAreaOfIsland(grid,i,j+1)+dfsAreaOfIsland(grid,i,j-1);
    }
}

