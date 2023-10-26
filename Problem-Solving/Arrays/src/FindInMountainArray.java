public class FindInMountainArray {
    private static int binarySearch(int[] arr, int target, int low, int high) {
        // Store a boolean value by checking if the array is ascending or not
        boolean isAscending = arr[low] < arr[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = arr[mid];

            // If target = middle element
            if (target == midElement) {
                return mid;
            }

            // If the array is in ascending order
            if (isAscending) {
                // If the target > middle element 
                if (target > midElement) {
                    // Update the value of low to mid + 1
                    low = mid + 1;
                } 
                else {
                    // Update the value of high to mid - 1 
                    high = mid - 1;
                }
            }
            // Else, if the array is in descending order 
            else {
                // If target element > middle element
                if (target > midElement) {
                    // Update the value of high to mid - 1
                    high = mid - 1;
                } 
                else {
                    // Update the value of low to mid + 1
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int peakIndex(int[] arr) {
        // Intitalise two pointers, one pointing to the 0th index and the other pointing to the (n - 1)th index
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // If the (mid)th element  > (mid + 1)th element
            if (arr[mid] > arr[mid + 1]) {
                // Descending part of the array
                // Update high to mid
                high = mid;
            }
            // Else if, the (mid)th element  < (mid + 1)th element
            else {
                // Ascending part of the array
                // Update low to mid + 1
                low = mid + 1;
            }
        }

        return low;
    }

    private static int findInarr(int target, int[] arr) {
        // Store the peak index of the mountain array
        int peak = peakIndex(arr);
        // Store the minimum index by performing binary search on the left part of the peak index
        int index = binarySearch(arr, target, 0, peak);

        // If the minimum index != -1
        if (index != -1) {
            return index;
        }
        
        // Else, perform binary search on the right part of the peak index
        return binarySearch(arr, target, peak + 1, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3, 1};

        System.out.println("The minimum index of the target element is : " + findInarr(3, arr));
    }
}
