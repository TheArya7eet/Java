import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    // Approach 1 - Using Set data structure
    private static List<List<Integer>> threeSumHashing(int[] arr){
        int n = arr.length;

        // Declare a HashSet of type List<Integer> to store the unique triplets
        Set<List<Integer>> set = new HashSet<>();

        for(int i =0; i < n; i++){
            // Declare a HashSet of type Integer to store the array elements as we intend to search for the third element
            Set<Integer> hashset = new HashSet<>();

            for(int j = i + 1; j < n; j++){
                // The third element will be 0 - (arr[i] + arr[j])
                int third = -(arr[i] + arr[j]);

                // If the HashSet contains the third element
                if(hashset.contains(third)){
                    // Create a list to store the triplet
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    // Sort the list
                    temp.sort(null);
                    // Insert the list to the 'set' HashSet
                    set.add(temp);
                }
                // Insert the j-th element i.e. arr[j] in the HashSet as we only want to insert those array elements that are in between indices i and j
                hashset.add(arr[j]);
            }
        }

        // Store the list triplets in the set, in a new 'ans' ArrayList 
        List<List<Integer>> ans = new ArrayList<>(set);
        // Return the 'ans' list
        return ans;
    }

    // Approach 2 - Using two pointer
    private static List<List<Integer>> threeSum(int[] arr){
        int n = arr.length;

        // Declare a ArrayList of type List<Integer> to store our triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the given array
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            // If i != 0 and ith element == (i - 1)th element, we dont need to check for the triplets as we will come up with duplicate triplets
            // So continue to the next value of i
            if(i != 0 && arr[i] == arr[i - 1]) continue;

            // Initialise the two pointers : j at (i + 1) and k at (n - 1)
            int j = i + 1, k = n - 1;

            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];

                // If sum of the triplets is > 0, we need lesser elements so we decrement the value of k by 1
                if(sum > 0) k--;
                // Else if sum of the triplets is < 0, we need greater elements so we increment the value of j by 1
                else if(sum < 0) j++; 
                // Else
                else{
                    // Store the triplet
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    
                    // Add the triplet tot he 'ans' ArrayList
                    ans.add(temp);
                    
                    // Increment the value of j by 1 and decrement the value of k by 1
                    j++;
                    k--;

                    // Skip the duplicates
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans; 
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
}
