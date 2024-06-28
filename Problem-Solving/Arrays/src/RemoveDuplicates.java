
import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {
    private static ArrayList<Integer> removeDuplicates(int[] arr, int n){
        int value  = Integer.MAX_VALUE;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if(arr[i] != value){
                value = arr[i];
                list.add(arr[i]);
            }
        }

        return list;
    }

    // Remove duplicates if the array is unsorted (using HashSet)
    private static void removeDuplicates2(int[] arr, int n){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(arr[i]);
        }

        for(Integer i : set){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        System.out.println(removeDuplicates(arr, arr.length));
    }
}
