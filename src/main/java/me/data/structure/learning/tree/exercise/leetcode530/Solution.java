package me.data.structure.learning.tree.exercise.leetcode530;

import me.data.structure.learning.tree.node.TreeNode;

class Solution {
    /**
     * 二叉搜索树最小绝对差值
     * 思路 二叉搜索树中序投影是递增的关系，中序遍历 后 两两做差取最小值
     * 中序排列的算法样例
     * <pre>
     * inOrder(TreeNode root){
     *   inOrder(root.left)
     *   root.val
     *   inOrder(root.right)
     * }
     * </pre>
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode<Integer> root) {
        min = Integer.MAX_VALUE;
        if (root == null) {
            return 0;
        }

        inOrder(root);
        return min;

    }

    private void inOrder(TreeNode<Integer> root) {
        if(root == null) return;

        inOrder(root.left);

        if (previous == null) {
            previous = root.val;
        } else {
            min = Math.min(root.val - previous, min);
            previous = root.val;
        }
        inOrder(root.right);

    }

    Integer previous;
    Integer min;
}