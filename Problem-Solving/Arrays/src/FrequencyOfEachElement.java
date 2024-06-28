
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfEachElement {

    private static void printFreq1(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] arr2 = new int[max + 1];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]]++;
        }

		for(int i = 0; i < arr2.length; i++){
			if(arr2[i] != 0) System.out.println(i + "-> " + arr2[i]);
		}
    }

    private static void printFreq2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 10, 15, 10, 5};

        printFreq1(arr);
    }
}
