package me.data.structure.learning.tree.exercise.leetcode226;

import me.data.structure.learning.tree.node.TreeNode;

class Solution {
    /**
     * 反转一个二叉树 就是左右子树交换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}