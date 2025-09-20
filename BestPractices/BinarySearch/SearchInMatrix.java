package BestPractices.BinarySearch;
public class SearchInMatrix {
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / cols;
            int midCol = mid % cols;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
       return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };        
        int target = 16;
        boolean found = searchMatrix(matrix, target);
        System.out.println("Searching for " + target + " in the matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }       
        if (found) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }
}