package me.data.structure.learning.tree.exercise.leetcode652;

import me.data.structure.learning.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
class Solution {
    private List<TreeNode> list = new ArrayList();
    private Map<String,Integer> map = new HashMap();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return list;
        helper(root);
        return list;
    }

    private String helper(TreeNode root){
        if(root==null) return "#";

        String str = root.val  +","+ helper(root.left)+"," + helper(root.right);
        map.put(str,map.getOrDefault(str,0)+1);
        if(map.get(str) == 2){
            list.add(root);
        }
        return str;

    }
}