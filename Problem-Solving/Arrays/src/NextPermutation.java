import java.util.Arrays;

public class NextPermutation {
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

    private static void nextPermutation(int[] arr){
        int index = -1;

        for(int i = arr.length - 2; i >= 0; i--){
            // If the current element is greater than the next element
            if(arr[i] < arr[i + 1]){
                // The current index is the breaking point index
                index = i;
                break;
            }
        }

        // If  no breaking point index is found
        if(index == -1){
            // Reverse the entire given array
            reverseArray(arr, 0, arr.length);
            return;
        }

        for(int i = arr.length - 1; i > index; i--){
            // If the current element is greater than the  element at the breaking point index
            if(arr[i] > arr[index]){
                // Swap them
                swap(arr, i , index);
                break;
            }
        }

        // Reverse the array from (index + 1) to (arr.length - 1)
        reverseArray(arr, index + 1, arr.length);
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};

        nextPermutation(arr);

        System.out.println("The next permutation of the given array is: " + Arrays.toString(arr));
    }
}
