
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrays {
     
    // Find the number of intersections
    private static int IntersectionCount(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // Store the unique elements of arr1 in the set
        for (int i : arr1) {
            set.add(i);
        }

        int count = 0;

        for (int i : arr2) {
            // If the set contains the ith element of arr2
            if (set.contains(i)) {
                // Increment count
                count++;
                // Remove the ith element from the set, so that if there is a repeating element in arr2, it does not get compared to the element in the set
                set.remove(i);
            }
        }

        return count;
    }

    // Find the intersection elements
    private static int[] Intersection(int[] arr1, int[] arr2){
        HashSet<Integer> set1 = new HashSet<>();

        for(int i : arr1){
            // Add the unique elements of arr1 to set1
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();

        for(int i : arr2){
            // If set1 contains the ith element, add it to set2 (if the ith element occurs again in the arr2, it will not be added again because we are adding it in a set)
            if(set1.contains(i)) set2.add(i);
        }

        int[] result = new int[set2.size()];

        int i = 0;
        for(int n : set2){
            // Add the elements in set2 to result 
            result[i] = n;
            i++;
        }

        return result;
    } 

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9, 4}, arr2 = {6, 3, 9, 2, 9, 4};

        // System.out.println("The number of intersections is: " + IntersectionCount(arr1, arr2));
        System.out.println("The intersection elements are: " + Arrays.toString(Intersection(arr1, arr2)));
    }
}
