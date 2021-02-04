package me.data.structure.learning.tree.exercise;

import me.data.structure.learning.tree.node.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
        //异常处理
        if (root == null) {
            return false;
        }
        //递归到叶子节点时一定是等于叶子节点的值
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}