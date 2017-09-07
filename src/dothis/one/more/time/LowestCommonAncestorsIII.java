package dothis.one.more.time;

import util.TreeNode;

/**
 * Find the lowest common ancestors for binary tree
 */

class ResultType{
    boolean foundA;
    boolean foundB;
    TreeNode ancestor;

    public ResultType(boolean foundA, boolean foundB, TreeNode ancestor) {
        this.foundA = foundA;
        this.foundB = foundB;
        this.ancestor = ancestor;
    }
}

public class LowestCommonAncestorsIII {
    public TreeNode getAncestor(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = getAncestorHelper(root, A, B);
        if (result.foundA && result.foundB) {
            return result.ancestor;
        }
        return null;
    }

    private ResultType getAncestorHelper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        ResultType left = getAncestorHelper(root.left, A, B);
        ResultType right = getAncestorHelper(root.right, A, B);

        // Need to decide value for foundA and foundB
        // So can't return before we have left and right ready when root equals to any one of them
        boolean isAPresent = left.foundA || right.foundA || root == A;
        boolean isBPresent = left.foundB || right.foundB || root == B;

        if (root == A || root == B) {
            return new ResultType(isAPresent, isBPresent, root);
        }
        if (left.ancestor != null && right.ancestor != null) {
            return new ResultType(isAPresent, isBPresent, root);
        }
        if (left.ancestor != null) {
            return new ResultType(isAPresent, isBPresent, left.ancestor);
        }
        if (right.ancestor != null) {
            return new ResultType(isAPresent, isBPresent, right.ancestor);
        }
        return new ResultType(isAPresent, isBPresent, null);
    }
}
