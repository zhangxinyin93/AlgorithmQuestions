package dothis.one.more.time;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        pathSumHelper(root, sum, path, paths);

        return paths;
    }

    //递归的定义
    //发现一开始的基本定义已经不够用了，所以我们需要更多的东西
    private void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        //递归的出口
        if (root == null) {
            return;
        }

        //递归的拆解
        path.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            //Deep Copy
            paths.add(new LinkedList<>(path));
        }

        pathSumHelper(root.left, sum - root.val, path, paths);
        pathSumHelper(root.right, sum - root.val, path, paths);

        //因为是pass reference，所以这种公共用的变量我们不应该改变它的值，进来加了什么走的时候要移出去
        path.remove(path.size() - 1);
    }
}
