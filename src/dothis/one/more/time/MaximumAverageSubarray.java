package dothis.one.more.time;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive and negative numbers,
 * find the maximum average subarray which length
 * should be greater or equal to given length k.
 */
public class MaximumAverageSubarray {

    /**
     * This method is a typical one
     * Resolve a problem concern with subarray, we can always come up with
     * the idea to do subtraction between sum[i] and sum[j] to get the sum
     * of subarray(i,j)
     * @param nums
     *          input array
     * @param k
     */
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

    /**
     * 二分法解决问题
     * 二分思想：最大平均值一定在一组最大值和最小值之间，这个间隔越来越小就越来越准确
     *          所以设置了一个间隔为1E-6代表两值相差0.000001
     * @param nums
     * @param k
     * @return
     */
    public double maxAverageByBinarySearch(int[] nums, int k) {
        double leftBound = Integer.MIN_VALUE;
        double rightBound = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < leftBound) {
                leftBound = nums[i];
            }
            if (nums[i] > rightBound) {
                rightBound = nums[i];
            }
        }

        while (rightBound - leftBound >= 1E-6) {
            double mid = (leftBound + rightBound) / 2;

            if (isValidSubarray(nums, mid, k)) {
                leftBound = mid;
            } else {
                rightBound = mid;
            }
        }
        return leftBound;
    }

    private boolean isValidSubarray(int[] nums, double mid, int k) {
        double min_pre = 0;
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1] - mid;

            // 减去前面的最小值就可以获取最大sum的subarray
            if (i >= k && sum[i] - min_pre >= 0) {
                return true;
            }

            if (i >= k) {
                min_pre = Math.min(min_pre, sum[i-k+1]);
            }
        }
        return false;
    }
}
