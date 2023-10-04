public class KadanesAlgorithm{
    private static int MaxSubArray(int[] arr, int n){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
          currSum += arr[i];

          maxSum = Math.max(maxSum, currSum);
          
          if(currSum < 0){
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