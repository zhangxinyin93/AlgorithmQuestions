/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 */
public class MaximumSubarray {
    /**
     * Using prefix sum
     * .........i-1, i, .............., j.......
     * ____________sum(i-1)
     * _________________________________sum(j)
     * 做减法得到中间的sum(i,j)
     * @param nums
     *          A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
