import java.util.Arrays;

public class SortArrayOf012{
    // Dutch National Flag Algorithm
    // In this algorithm, these are the points to remember
    // (0 -> low - 1) elements are all 0s
    // (low -> mid - 1) elements are all 1s
    // (mid -> high) elements are 0s, 1s and 2s in unsorted manner
    // (high + 1 -> arr.length - 1) elements are all 2s

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void Sort(int[] arr){
        int mid = 0, low = 0, high = arr.length - 1; 

        while(mid <= high){
            // If arr[mid] = 0
            if(arr[mid] == 0){
                // Swap arr[mid] and arr[low]
                swap(arr, mid, low);
                // Increment both low and mid by 1
                mid++;
                low++;
            }

            // Else if, arr[mid] = 1
            else if(arr[mid] == 1){
                // Don't perform any swap
                // Increment mid by 1
                mid++;
            }

            // Else if, arr[mid] = 2
            else{
                // Swap arr[mid] and arr[high]
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 1, 2};
        
        Sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}