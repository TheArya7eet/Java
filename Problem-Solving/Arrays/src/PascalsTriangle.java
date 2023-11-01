// Given number of rows, print the Pascal's Triangle

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static List<List<Integer>> printTriangle(int numRows){
        // Declare an ArrayList which will store the rows of the Pascal's Triangle 
        List<List<Integer>> finalList = new ArrayList<>();

        // Run a loop row that will signify the rows ranging from (0 to numRows - 1) or (1 to numRows) 
        for(int row = 0; row < numRows; row++){
            // Create a temporary list which will store each row of the triangle for every value of 'row'
            List<Integer> temp = new ArrayList<>();
            long ans = 1; 

            // Add 1 to the row just after declaring it, because the first element in each row of the Pascal Triangle is always 1
            temp.add((int) ans);

            // Run a loop col that will signify the columns ranging from (0 to row index - 1) or (1 to row index) [because in each row, there are (row index + 1) or (row index) number of columns]
            for(int col = 1; col  <= row; col++){
                // current element = previous element * (row index - column index) / (column index + 1) [columns ranging from 0 to (row index - 1)]
                // current element = previous element * (row index - column index + 1) / column index [columns ranging from 1 to row index]
                ans = ans * (row - col + 1);
                ans = ans / col;

                temp.add((int) ans);
            }

            // After the loop 'col' ends, add the temp list to the finalList
            finalList.add(temp);
        }

        return finalList;
    }

    public static void main(String[] args) {
        System.out.println(printTriangle(3));
    }
}
