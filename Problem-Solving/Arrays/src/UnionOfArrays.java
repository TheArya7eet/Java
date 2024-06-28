import java.util.HashSet;

public class UnionOfArrays {
    private static void Union(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        // Add the elements of arr1 to the set
        for(int i : arr1){
            set.add(i);
        }

        // Add the elements of arr2 to the set
        for(int i : arr2){
            set.add(i);
        }

        for(int i : set){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9, 4}, arr2 = {6, 3, 9, 2, 9, 4};

        Union(arr1, arr2);
    }    
}
