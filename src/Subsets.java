import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new LinkedList<>();
        List<List<Integer>> subsets = new LinkedList<>();
        boolean[] isVisited = new boolean[nums.length];

        if (nums == null) {
            return subsets;
        }

        subsets.add(new LinkedList<>());
        subsetsHelper(nums, subset, subsets, 0, isVisited);

        return subsets;
    }

    private void subsetsHelper(int[] nums, List<Integer> subset, List<List<Integer>> subsets, int index, boolean[] isVisited) {
        if (index == nums.length) {
            return;
        }

        // 从当前这个点开始往后还有多少个点需要check
        for (int i = index; i < nums.length; i++) {
            if (!isVisited[i]) {
                subset.add(nums[i]);
                subsets.add(new LinkedList(subset));
                isVisited[i] = true;
                subsetsHelper(nums, subset, subsets, i, isVisited);

                // 永远记得这种需要公用的，要把加进来的东西移出去，改变的值改回来
                subset.remove(subset.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
