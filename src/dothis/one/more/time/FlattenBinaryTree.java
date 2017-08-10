package dothis.one.more.time;

import util.TreeNode;

/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *               1
                  \
     1             2
    / \             \
   2   5     =>      3
  / \   \             \
 3   4  6              4
                        \
                         5
                          \
                           6
 */
public class FlattenBinaryTree {

    public void flat(TreeNode root) {
        flatHelper(root);
    }

    private util.TreeNode flatHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLastNode = flatHelper(root.left);
        TreeNode rightLastNode = flatHelper(root.right);

        if (leftLastNode != null) {
            leftLastNode = root.right;
            root.right = leftLastNode;
            root.left = null;
        }

        if (rightLastNode != null) {
            return rightLastNode;
        }

        if (leftLastNode != null) {
            return leftLastNode;
        }

        return root;
    }
}
