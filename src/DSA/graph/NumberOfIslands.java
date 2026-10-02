package DSA.graph;

public class NumberOfIslands {
    private static int n;
    private static int m;
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int count=0;
        n = grid.length;
        if(n==0) return 0;
        m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){//if land check its surrounding
                    dfsMarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfsMarking(char[][] grid,int i,int j){//i is row and j is column

        //check for invalid case

        if(i<0 || i>=n || j<0 ||j>=m || grid[i][j] != '1') return;

        grid[i][j] ='0';//mark intiai grid[i][j]==visited{by assign 0}

        dfsMarking(grid,i+1,j);
        dfsMarking(grid,i-1,j);
        dfsMarking(grid,i,j+1);
        dfsMarking(grid,i,j-1);
    }
}
