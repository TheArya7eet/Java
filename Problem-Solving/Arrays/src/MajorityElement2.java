import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    // Element is the majority element if if occurs for > n/3 times (where n =
    // length of the array)
    // Extended Boyer Moore's Voting Algorithm
    private static List<Integer> majorityElement2(int[] arr){
        int n = arr.length;

        // Store the counts of the two possible majority elements 
        int count1 = 0, count2 = 0;
        // Store the elements we are counting
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            // If count1 = 0 and element2 != current element
            if(count1 == 0 && element2 != arr[i]){
                // Update value of count1 to 1
                count1 = 1;
                // Update the value of element1 to the current element
                element1 = arr[i];
            }
            // If count2 = 0 and element1 != current element
            else if(count2 == 0 && element1 != arr[i]){
                // Update the value of count2 to 1
                count2 = 1;
                // Update the value of element2 to the current element
                element2 = arr[i];
            }
            // If element1 = current element, increment count1 by 1
            else if(element1 == arr[i]) count1++;
            // If element2 = current element, increment count2 by 1
            else if(element2 == arr[i]) count2++;
            else{
                // Decrement count1 and count2 by 1
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();

        count1 = 0; 
        count2 = 0;

         // Manually check if the stored elements in element1 and element2 are majority elements
        for(int i = 0; i < n; i++){
            if(arr[i] == element1) count1++;
            if(arr[i] == element2) count2++;
        }

        int min = (int) (n / 3) + 1;
        if(count1 >= min) list.add(element1);
        if(count2 >= min) list.add(element2);

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 2};

        System.out.println(majorityElement2(arr));
    }
}
