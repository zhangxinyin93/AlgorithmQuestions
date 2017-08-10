import util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 递归的定义：递归得到子树的max depth
    private int getHeight(TreeNode root) {

        // 递归的出口
        if (root == null) {
            return 0;
        }

        // 递归的拆解
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        // 递归的出口以及要做些什么
        // 记得1和-1也可以表示true和false
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
