package me.data.structure.learning.tree.node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by songwenchao on 2019-09-01
 */
public class TreeBuilder<V extends Comparable<V>> {

    TreeNode build(V[] values) {
        TreeNode root = null;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                root = newTree(null, values[0]);
            } else {
                root = newTree(root, values[i]);
            }
        }
        return root;
    }

    private TreeNode newTree(TreeNode node, V object) {

        if (node == null) {
            node = new TreeNode(object);
        } else if (node.getVal().compareTo(object) > 0) {
            node.left = newTree(node.left, object);
        } else {
            node.right = newTree(node.right, object);
        }
        return node;
    }

    public List<V> preTraversal(TreeNode<V> root) {
        if (this == null) {
            return new ArrayList<>();
        } else {
            List<V> list = new ArrayList<>();
            list.add(root.getVal());
            if (root.left != null) {
                list.addAll(preTraversal(root.left));
            }
            if (root.right != null) {
                list.addAll(preTraversal(root.right));
            }
            return list;
        }
    }

    public List<V> preTravelSalWithoutRecursion(TreeNode<V> root) {

        LinkedList<TreeNode<V>> stack = new LinkedList<>();
        List<V> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        } else {
            stack.push(root);
            while (!stack.isEmpty()) {

                root = stack.pop();
                result.add(root.getVal());

                if (root.right != null) {
                    stack.push(root.right);
                }

                if (root.left != null) {
                    stack.push(root.left);

                }
            }
        }
        return result;
    }

}
