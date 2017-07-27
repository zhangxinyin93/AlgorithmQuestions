/**
 * Given an array with positive and negative numbers,
 * find the maximum average subarray which length
 * should be greater or equal to given length k.
 */
public class MaximumAverageSubarray {
    public double maxAverageBySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return (double)Integer.MIN_VALUE;
        }

        // Maybe the component in array is the max or min value of Integer
        // This point should always be called out
        long[] sum = new long[nums.length + 1];

        // Get the sum from 0 to element i
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i - 1];
        }

        double result = (double)Integer.MIN_VALUE;

        // Using the sum(i,j) = sum(0,j) - sum(0,i);
        for (int j = nums.length; j >= 0; j--) {
            for(int i = 0; i < nums.length; i++) {
                if (j - i >= k && (((double)(sum[j] - sum[i])) / (double)(j-i) > result)) {
                    result = (double)(sum[j] - sum[i]) / (double)(j-i);
                } else if (j - i < k) {
                    continue;
                }
            }
        }
        return result;
    }
}
