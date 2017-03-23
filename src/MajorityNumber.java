import java.util.ArrayList;

/**
 * Given an array of integers, the majority number is the number that
 * occurs more than half of the size of the array. Find it.
 * Assume it always exists, and non-empty array
 */
public class MajorityNumber {

    /**
     * Using Moore's Algorithm, solved problem in O(n) time complexity and O(1) space
     * General idea: 每个候选者有他的票就count加,没有就减,最后剩下的一定是投票数超过一般的,
     * 如果Majority存在的话。因此precisely这个算法还有phase two就是检查最后剩下的candidate
     * 是不是真的majority。
     * @param nums
     *          Input array
     * @return Majority Number
     */
    public int findMajorityNumber(ArrayList<Integer> nums) {
        int candidate = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            }
            else if (nums.get(i) == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        return candidate;
    }
}
