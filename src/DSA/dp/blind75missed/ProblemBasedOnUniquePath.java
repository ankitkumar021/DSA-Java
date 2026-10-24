package DSA.dp.blind75missed;
//Q1 Given a matrix of arrows , check whether from Top -Left you can reach bottom down.
//https://leetcode.com/discuss/post/2200499/dp-world-sde-1-backend-virtual-sept-2021-2a0v/

//asked in dp world
public class ProblemBasedOnUniquePath {
    public static void main(String[] args) {
        char[][] matrix = {{'R','D','L'},{'R','R','D'}};
        System.out.println(canReach(matrix));

    }
    public static boolean canReach(char[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;
        int steps = 0;

        while(row>= 0 && row<n && col>=0 && col<m){
            if(row == n-1 && col == m-1){
                return true;//we have reached the end
            }
            if(steps >= n*m){
                return false;//if there are cycle
            }

            steps++;

            char dir = matrix[row][col];

            if(dir == 'R'){
                col++;

            }
            else if (dir == 'L'){
                col--;

            } else if (dir == 'D') {
                row++;
            }
            else {
                row--;

            }
        }
        return false;
    }
}
