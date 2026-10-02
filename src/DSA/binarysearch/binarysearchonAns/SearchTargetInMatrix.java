package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchTargetInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //since m*n matrix
        int row = matrix.length;
        int col = matrix[0].length;

        int s = 0;
        int e = row - 1;
        int targetRow = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            //first if condition checks if there is target in the same row,
            // return the row and apply bs on this row alone
            if (target >= matrix[m][0] && target <= matrix[m][col - 1]) {
                targetRow = m;//i got the row where target is present(same row)
                break;
            }
            //if target is less than mid row first ele and we know it is sorted row wise
            //go above to find smalller number
            if (matrix[m][0] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }

        }
        if (targetRow == -1) return false;

        int left = 0;
        int right = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }
}
