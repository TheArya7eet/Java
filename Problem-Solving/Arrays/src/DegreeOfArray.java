import java.util.HashMap;

public class DegreeOfArray{
    private static int findShortestSubArray(int[] arr){
        HashMap <Integer, Integer> first = new HashMap();
        HashMap <Integer, Integer> count = new HashMap();
        int degree = 0;
        int minLength = 0;

        for(int i = 0; i < arr.length; i++){
            // Store the first occurrence index of the current element
            first.putIfAbsent(arr[i], i);
            
            // Store the number of occurrences of the current element
            count.put(arr[i], (count.getOrDefault(arr[i], 0) + 1)); 

            // If the number of occurrences of the current element is > degree
            if(count.get(arr[i]) > degree){
                // Update the value of degree to the number of occurrences of the current element
                degree = count.get(arr[i]);
                // Store the length from the first occurrence to the current (or last) occurrence of the current element
                minLength = i - first.get(arr[i]) + 1;
            }
            // Else if the number of occurrences of the current element is = degree
            else if(count.get(arr[i]) == degree){
                // Store the minimum of the lengths from the first occurrence to the current (or last) occurrence of both the elements
                minLength = Math.min(minLength, i - first.get(arr[i]) + 1);
            }
        }

        return minLength;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 3};

        System.out.println("The shortest sub-array of the maximum occurring element is: " + findShortestSubArray(arr));
    }
}