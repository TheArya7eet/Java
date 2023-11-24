import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Approach 1 - Hashing
    private static int[] twoSum1(int[] arr, int target) {
        // Store the array elements and their respective indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Store the current element
            int num = arr[i];
            // Store the remaining number needed from the target
            int moreNeeded = target - num;

            // If the HashMap contains the index at which the remaining number is present
            if (map.containsKey(moreNeeded)) {
                // Return the current index and the index of the remaining number
                return new int[] {i, map.get(moreNeeded)};
            }

            // Put the current element and its index in the HashMap
            map.put(arr[i], i);
        }

        return new int[] { -1, -1 };
    }

    // Approach 2 - Two Pointer
    private static int[] twoSum2(int[] arr, int target){
        // Sort the array
        Arrays.sort(arr);

        // Initialise two pointers - left and right, pointing to first and last indices of the array
        int left = 0, right = arr.length - 1;

        // Until left pointer becomes greater than or equal to right pointer
        while(left < right){
            // Create a variable to store the sum of arr[left] and arr[right]
            int sum = arr[left] + arr[right];
            
            // If sum < target, we need larger elements to increase the sum, so increment the left pointer by 1 
            if(sum < target) left++;
            // If sum > target, we need smaller elements to decrease the sum, so decrement the right pointer by 1
            else if(sum > target) right--;
            // else, sum = target, so return the indices left and right
            else return new int[] {left, right};
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };

        System.out.println(Arrays.toString(twoSum1(arr, 3)));
    }
}