import java.util.Arrays;

public class SetMatrixZeroes {
    private static void SetMatrixZeroes(int[][] matrix) {
        // Number of rows
        int n = matrix.length;
        // Number of columns
        int m = matrix[0].length;
        // Initialize a variable col0 with 1, which will serve the purpose of the col
        // array
        int col0 = 1;

        // Traverse the matrix
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // If the [r][c]th element is 0
                if (matrix[r][c] == 0) {
                    // Update the value of the [r][0]th element to 0
                    matrix[r][0] = 0;

                    // If it is not the 0th column
                    if (c != 0) {
                        // Update the value of the [0][c]th element to 0
                        matrix[0][c] = 0;
                    }
                    // Else it is the 0th column
                    else {
                        // Update the value of col0 to 0
                        col0 = 0;
                    }
                }
            }
        }

        // Traverse the matrix from [1][1]th element to the [n - 1][m - 1]th element
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                // If the [r][0]th element is 0 OR [0][c]th element is 0
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    // Update the value of the [r][c]th element to 0
                    matrix[r][c] = 0;
                }
            }
        }

        // If the [0][0]th element is 0
        if (matrix[0][0] == 0) {
            for (int c = 0; c < n; c++) {
                // Update the value of the 0th row elements to 0
                matrix[0][c] = 0;
            }
        }

        // If the col0 is 0
        if (col0 == 0) {
            for (int r = 0; r < n; r++) {
                // Update the value of the 0th column elements to 0
                matrix[r][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };

        SetMatrixZeroes(matrix);

        for (int r = 0; r < matrix.length; r++) {
            System.out.println(Arrays.toString(matrix[r]));
        }
    }
}
