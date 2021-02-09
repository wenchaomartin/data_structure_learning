package me.data.structure.learning.tree.exercise.leetcode606;

import me.data.structure.learning.tree.node.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left ==null && t.right ==null) return t.val +"";
        if(t.right == null) return t.val+"("+ tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }
}