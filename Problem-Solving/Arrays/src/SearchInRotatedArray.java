public class SearchInRotatedArray {
    private static int search(int[] arr, int target){
        // Initialise two pointers - low (pointing to the 0th index) and high (pointing to the last index)
        int low = 0, high = arr.length - 1;

        while(low <= high){
            // Find the middle index
            int mid = low + (high - low) / 2;

            // If the target element is present at the mid index
            if(target == arr[mid]){
                // Return the mid index
                return mid;
            }

            // If the element at low <= element at mid 
            if(arr[low] <= arr[mid]){
                // The left part of the array is sorted
                // Now if the target value lies between the element at low and the element at mid
                if(target >= arr[low] && target < arr[mid]){
                    // Update the value of high to  (mid - 1)
                    high = mid - 1;
                } 
                // Else
                else{
                    // Update the value of low to (mid + 1)
                    low = mid + 1; 
                }
            }
            // Else if,  element at mid <= element at high 
            else if(arr[mid] <= arr[high]){
                // The right part of the array is sorted
                // Now if the target value lies between the element at mid and the element at high
                if(target > arr[mid] && target <= arr[high]){
                    // Update the value of low to (mid + 1)
                    low = mid + 1;
                }
                // Else
                else{
                    // Upadte the value of high to (mid - 1)
                    high = mid - 1;
                }
            }
        }

        // If the target is not found
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("The target is present at index: " + search(new int[] {7, 6, 1, 2, 3, 4, 5}, 4));
    }
}
