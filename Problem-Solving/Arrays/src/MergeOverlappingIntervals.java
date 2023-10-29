import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {
    private static int[][] MergeIntervals(int[][] arr) {
        int n = arr.length;

        // Declare an ArrayList to store the merged intervals
        ArrayList<int[]> ans = new ArrayList<>();

        // Sort the given array
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < arr.length; i++) {
            // If the ans list is empty OR first element of the current interval is greater
            // than the last inserted interval
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                // Add the current interval to ans
                ans.add(arr[i]);
            }
            // If the first element of the current interval is lesser than the last added
            // interval
            else {
                // Merge the current interval with the last inserted interval
                ans.get(ans.size() - 1)[1] = Math.max(arr[i][1], ans.get(ans.size() - 1)[1]);
            }
        }

        return ans.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        arr = MergeIntervals(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("The Overlapping Intervals are:  " + Arrays.toString(arr[i]));
        }
    }
}