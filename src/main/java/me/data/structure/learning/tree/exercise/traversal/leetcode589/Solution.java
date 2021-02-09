package me.data.structure.learning.tree.exercise.traversal.leetcode589;

import java.util.ArrayList;
import java.util.List;

/**
 * n 叉树的先序遍历
 */
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList();
        List<Integer> list = new ArrayList();
        list.add(root.val);
        List<Node> childrenList = root.children;
        if (childrenList != null) {
            for (Node node : childrenList) {
                list.addAll(preorder(node));
            }
        }
        return list;

    }
}