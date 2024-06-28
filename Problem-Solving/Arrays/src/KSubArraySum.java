
import java.util.HashMap;

public class KSubArraySum {
    // Brute Force Approach
    private static int subarraySumBrute(int[] arr, int k){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                int sum = 0;
                for(int K = i; K < j; K++){
                    sum += arr[K];

                    if(sum == k){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Better Approach
    private static int subarraySumBetter(int[] arr, int k){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal Approach
    private static int subarraySum(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefSum = 0, count = 0;

        for(int i : arr){
            prefSum += i;

            if(map.containsKey(prefSum - k)){
               count += map.get(prefSum - k);
               map.put(prefSum, map.getOrDefault(prefSum, 0) + 1); 
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1); 
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};

        System.out.println(subarraySum(arr, 2));
    }
}
