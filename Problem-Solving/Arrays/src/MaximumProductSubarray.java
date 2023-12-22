public class MaximumProductSubarray {
    private static int maxProduct(int[] arr) {
        int n = arr.length;

        // Declare 2 variables - pref and suff, both initialised with 1
        int pref = 1, suff = 1;

        // Declare a 'max' variable which will be returned as the maximum product of the subarray
        int  max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // If pref = 0: This means the previous element was 0. 
            // So, we will consider the current element as a part of the new subarray.
            if (pref == 0)
                pref = 1;
            // If suff = 0: This means the previous element was 0. 
            // So, we will consider the current element as a part of the new subarray.
            if (suff == 0)
                suff = 1;

            pref *= arr[i];
            suff *= arr[i];

            max = Math.max(max, Math.max(pref, suff));
        }

        return max;
    }
}
