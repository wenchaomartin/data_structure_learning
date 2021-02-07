package me.data.structure.learning.tree.exercise.leetcode671;

import me.data.structure.learning.tree.node.TreeNode;

class Solution {
    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode<Integer> root) {
        if (root == null) return -1;
        return helper(root, root.val);
    }

    private Integer helper(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val.compareTo(min) > 0) return (Integer) root.val;
        int left = helper(root.left, min);
        int right = helper(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}