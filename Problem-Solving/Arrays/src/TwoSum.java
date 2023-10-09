import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    private static int[] twoSum(int[] arr, int target) {
        // Store the array elements and their respective indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Store the current element
            int num = arr[i];
            // Store the remaining number needed from the target
            int moreNeeded = target - arr[i];

            // If the HashMap contains the index at which the remaining number is present
            if (map.containsKey(moreNeeded)) {
                // Return the current index and the index of the remaining number
                return new int[] { i, map.get(moreNeeded) };
            }

            // Put the current element and its index in the HashMap
            map.put(arr[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };

        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}