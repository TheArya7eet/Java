
import java.util.Arrays;

public class RearrangeArray {
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void reverseArray(int[] arr, int start, int end){
        int i = start, j = end - 1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void rearrange(int[] arr){
        Arrays.sort(arr);


        // Find the middle index
        int mid = arr.length / 2;

        // Reverse the right half of the array
        reverseArray(arr, mid, arr.length);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {8, 7, 1, 6, 5, 9};  
        
        rearrange(arr);
    }
}
