package dothis.one.more.time;

import util.TreeNode;

/**
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        //递归的出口
        if (root == null) {
            return 0;
        }

        //递归的拆解
        //答案的组成：左子树的path数 + 右子树的path数 + 从整棵树的root出发的path数
        //对于每一颗子树来说，又是这样构成了结果，而任意一条path其实都是从某颗子树的根出发，但不用到leaf的
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int findPath(TreeNode root, int sum) {
        //递归的出口
        if (root == null) {
            return 0;
        }

        int validPath = 0;
        if (root.val == sum) {
            validPath++;
        }

        int left = findPath(root.left, sum - root.val);
        int right = findPath(root.right, sum - root.val);

        return left + right + validPath;
    }
}
