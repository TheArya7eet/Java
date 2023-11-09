import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Approach 1 - By sorting
    private static int longestConsecutive1(int[] arr){
        // If the array is empty, there is no sequence
        if(arr.length == 0) return 0;

        // Sort the array
        Arrays.sort(arr);

        // Declare a variable longest to store the maximum length
        int longest = 1;
        // Declare a variable lastSmaller to store the last included element of the current sequence
        int lastSmaller = Integer.MIN_VALUE;
        // Declare a variable currCount to store the length of the current sequence
        int currCount = 0;

        int n = arr.length;
        for(int i = 0; i < n; i++){
            // For every element,  check if it can be a part of the current sequence

            // If arr[i] - 1 is equal to lastSmaller, it indicates that arr[i] is the next consecutive element
            if(arr[i] - 1 == lastSmaller){
                // Update lastSmaller with the value of arr[i]
                lastSmaller = arr[i];
                // Increment length of the current sequence, i.e. currCount by 1
                currCount++;
            }
            // Else if arr[i] is equal to lastSmaller, skip it because we have already included it before
            else if(arr[i] == lastSmaller){
                continue;
            }
            // Else if arr[i] is not equal to lastSmaller, it indicates that arr[i] is not part of the sequence 
            else if(arr[i] != lastSmaller)
            {
                // So we will start a new sequence
                // Update the value of lastSmaller with the value of arr[i] 
                lastSmaller = arr[i];
                // Set the length of the current sequence, i.e. currCount to 1
                currCount = 1;
            }
            // Compare currCount and longest and update longest with the maximum value
            longest = Math.max(longest, currCount);
        }

        // Once the iteration is complete, we will have the answer stored in the variable longest
        return longest;
    }

    // Approach 2 - By using Set data structure
    private static int longestConsecutive2(int[] arr){
        // If the array is empty, there is no sequence
        if(arr.length == 0) return 0;

        // Declare a variable longest to store the maximum length of the sequence, initialised with 1
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        int  n = arr.length;
        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        // Iterate through the set to find the longest sequence
        for(int i : set){
            // If i is a starting number, i.e. set does not contain (i - 1)
            if(!set.contains(i - 1)){
                // Declare a variable currCount to store the length of the current sequence, initialised with 0
                int currCount = 1;
                // Store the current set element in a variable x
                int x = i;

                // Using the set, search for consecutive elements x + 1, x + 2, x + 3 and so on
                while(set.contains(x + 1)){
                    x++;
                    currCount++;
                }

                // After that, we will compare ‘cnt’ and ‘longest’ and update the variable ‘longest’ with the maximum value
                longest = Math.max(longest, currCount);
            }
        }

        // After the iteration is complete, we will get our longest consecutive sequence
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2, 8, 7, 6, 5};

        System.out.println("The length of the longest consecutive sequence is: " + longestConsecutive2(arr));
    }
}
