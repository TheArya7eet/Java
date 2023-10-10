public class PeakOfMountainArray {
    private static int findPeakIndex(int[] arr){
        int low = 0, high = arr.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;

            // If the (mid)th element  > (mid + 1)th element
            if(arr[mid] > arr[mid + 1]){
                // Descending part of the array
                // Update high to mid
                high = mid;
            }
            // Else if, the (mid)th element  < (mid + 1)th element
            else if(arr[mid] < arr[mid + 1]){
                // Ascending part of the array
                // Update low to mid + 1
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3, 2};

        System.out.println(findPeakIndex(arr));
    }
}
