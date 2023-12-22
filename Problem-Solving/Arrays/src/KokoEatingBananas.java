public class KokoEatingBananas {
    // Approach 1
    private static int findHours(int[] piles, int bananasPerHour){
        int totalHrs = 0;

        for(int i = 0; i < piles.length; i++){
            totalHrs += Math.ceil((double)piles[i] / bananasPerHour);
        }

        return totalHrs;
    }

    private static int minEatingSpeed(int[] piles, int hours){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        for(int min = 1; min <= max; min++){
            int hoursReq = findHours(piles, min);

            if(hoursReq <= hours){
                return min;
            }
        }

        return -1;
    }

    // Approach 2 - Binary Search
    private static int minEatingSpeed2(int[] piles, int hours){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int low = 1, high = max;

        while(low <= high){
            int mid = low + (high - low)/2;

            int hoursReq = findHours(piles, mid);

            // If number of hours required in which Koko can finish eating all the bananas by eating 'mid' number of bananas per hour is less than or equal to the given number of hours 
            if(hoursReq <= hours){
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
        int[] arr = {3,6,7,11};

        System.out.println("Minimum number of bananas per hour: " + minEatingSpeed2(arr, 8));
    }
}
