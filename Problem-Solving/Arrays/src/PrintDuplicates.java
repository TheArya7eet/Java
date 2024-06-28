
import java.util.ArrayList;
import java.util.Arrays;

public class PrintDuplicates {
    private static ArrayList<Integer> print(int[] arr, int n){
        Arrays.sort(arr);
        ArrayList<Integer> list =  new ArrayList<>();

        int value = Integer.MAX_VALUE;

        for(int i = 0; i < n - 1; i++){
            if(arr[i] == arr[i + 1] && arr[i] != value){
                value = arr[i];
                list.add(arr[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 4};

        System.out.println(print(arr, arr.length));
    }
}
