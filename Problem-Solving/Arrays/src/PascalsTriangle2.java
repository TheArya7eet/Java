//GIven row r, print the rth row of the Pascal's Triangle

import java.util.ArrayList;

public class PascalsTriangle2 {
    private static ArrayList<Integer> printRow(int rowIndex) {
        // Declare an ArrayList which will store the rth row of the Pascal's Triangle
        ArrayList<Integer> row = new ArrayList<>();
        long ans = 1;

        // Add 1 to the row just after declaring it, because the first element in each row of the Pascal Triangle is always 1
        row.add((int) ans);

        // If you are asked to find the 0th row
        if (rowIndex == 0) {
            return row;
        }

        // Run a loop i that will signify the columns ranging from (0 to r - 1) or (1 to r) [because in each row, there are r columns]
        for (int col = 1; col <= rowIndex; col++) {
            // current element = previous element * (row index - column index) / (column index + 1) [columns ranging from 0 to (r - 1)]
            // current element = previous element * (row index - column index + 1) / column index [columns ranging from 1 to r]
            ans = ans * (rowIndex - col + 1);
            ans = ans / (col);
            row.add((int)ans);
        }

        return row;
    }

    public static void main(String[] args) {
        System.out.println(printRow(3));
    }
}
