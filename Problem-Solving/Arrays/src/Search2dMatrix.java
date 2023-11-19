import java.util.List;

public class Search2dMatrix {
    // Approach 1 - Binary Search
    private static boolean binarySearch(int[] row, int target){
        int low = 0, high = row.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(row[mid]== target) return true;
            else if(row[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    private static boolean searchMatrix1(int[][] matrix, int target){
        // Number of rows
        int n = matrix.length;
        // Number of columns in every row
        int m = matrix[0].length;

        // Iterate every row of the matrix
        for(int i = 0; i < n; i++){
            // If the target lies in the range of elements in the current row
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]){
                // Perform binary search on that row
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    // Approach 2 - Flattening the 2D matrix into a 1D array hypothetically
    private static boolean searchMatrix2(int[][] matrix, int target){
        int n = matrix.length, m = matrix[0].length;
        
        // Size of the hypothetical 1D array
        int size = n * m;

        // Declare two pointers - low and high
        int low = 0, high = size - 1;

        // Perform binary search 
        while(low <= high){
            // Find the mid index
            int mid  = low + (high - low) / 2;

            // Create the row and column position of the element in the matrix corresponding to the mid index of the 1D array
            int row = mid / m, col = mid % m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5},
                                      {7, 8 , 10},
                                      {11, 13, 15}};

        System.out.println(searchMatrix2(matrix, 3));
    }
}
