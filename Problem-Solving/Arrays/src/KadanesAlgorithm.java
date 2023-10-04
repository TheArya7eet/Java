public class KadanesAlgorithm{
    private static int MaxSubArray(int[] arr, int n){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
          // Add the current element to currSum
          currSum += arr[i];

          //  Store the maximum of maxSum and currSum
          maxSum = Math.max(maxSum, currSum);
          
          //  If the current sum is < 0
          if(currSum < 0){
            // Update the value of currSum back to 0
            currSum = 0;
          }
        }

        return maxSum;
    }
    public static void main(String[] args) {
      int[] arr = {-2, -1, -3, 4, -1, 3, -2};

      System.out.println("Maximum Sub-Array Sum is : " + MaxSubArray(arr, arr.length));
    }
}