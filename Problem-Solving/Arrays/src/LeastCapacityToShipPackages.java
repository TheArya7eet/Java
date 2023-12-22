public class LeastCapacityToShipPackages {
    // Approach 1 - Linear Search
    private static int findDays(int[] weights, int capacity){
        int load = 0, days = 1;

        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > capacity){
                days++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }

        return days;
    }

    private static int shipWithinDays(int[] weights, int days){
        int sum = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        for(int capacity = max;  capacity <= sum; capacity++){
            int daysReq = findDays(weights, capacity);

            if(daysReq <= days) return capacity;
        }

        return -1;
    }

    // Approach 2 - Binary Search
    private static int shipWithinDays2(int[] weights, int days){
        int sum = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int low = max, high = sum;

        while(low <= high){
            int mid = low + (high - low)/2;

            int daysReq = findDays(weights, mid);

            // If number of days required to ship the cargos in the ship having 'mid' capacity is less than or equal to the given number of days
            if(daysReq <= days){
                // On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers.
                // But we want the minimum number. 
                // So, we will eliminate the right half and consider the left half(i.e. high = mid-1)
                high = mid - 1;
            }
            // Else
            else{
                //  The value mid is smaller than the number we want. 
                // This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. 
                // So, we will eliminate the left half and consider the right half(i.e. low = mid+1)
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Least capacity to ship cargos is: " + shipWithinDays(arr, 5));
    }
}
