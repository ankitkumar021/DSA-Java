package DSA.binarysearch.binarysearchonAns;

//here we didn't apply the binary search approach totally
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class SearchTargetInMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//row
        int n = matrix[0].length;//col

        int row = m - 1;
        int col = 0;

//will start from last row and first col
        while (row >= 0 && col < n) {
            if (target == matrix[row][col]) {
                return true;
            }
            //smaller value should be present at the above row sice it is sort from top to bottom and we have started our iteration from bottom
            if (target < matrix[row][col]) {
                row = row - 1;
            } else {
                col = col + 1;

            }
        }
        return false;
    }
}
