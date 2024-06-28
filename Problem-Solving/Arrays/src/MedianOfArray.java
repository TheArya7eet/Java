
import java.util.Arrays;

public class MedianOfArray {
    private static double median(int[] arr, int n){
        Arrays.sort(arr);

        if(arr.length % 2 != 0) {
            return arr[arr.length / 2];
        }

        int start = 0, end = n -1;

        int mid = start + (end - start)/2;

        return (arr[mid] + arr[mid + 1])/2.0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3, 4};

        System.out.println(median(arr, arr.length));
    }
}
