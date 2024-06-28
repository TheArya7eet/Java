
public class MajorityElement {
    // Element is the majority element if if occurs for > n/2 times (where n = length of the array)

    // Moore's Voting Algorithm
    private static int majorityElement(int[] arr){
        // For tracking the count of every element
        int count = 0;
        // For which element we are counting
        int element = 0;

        for(int i = 0; i < arr.length; i++){
            // If count = 0
            if(count == 0){
                // Update the value of count to 1
                count = 1;
                // Update the value of the element we are counting to the current element
                element = arr[i];
            }

            // If current element is equal to the element we are counting
            else if(element == arr[i]){
                // Increment count by 1
                count++;
            }
            // Else 
            else{
                // Decrement count by 1
                count--;
            }
        }

        // Checking if the stored element is the majority element
        int count1 = 0;
        for(int i = 0; i  < arr.length; i++){
            // If the stored element = current element
            if(arr[i] == element){
                count1++;
            }
        }

        // If count1 > arr.length/2
        if(count1 > arr.length/2){
            return element;
        }

        return -1;
    }
    public static void main(String[] args) {
        // int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 1, 1, 1, 1};
        int[] arr = {1, 1, 1, 2, 3, 4, 4, 4};

        System.out.println("The Majority Element is: " + majorityElement(arr));
    }
}
