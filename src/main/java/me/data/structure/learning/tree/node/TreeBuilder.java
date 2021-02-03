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
        } else if (node.getValue().compareTo(object) > 0) {
            node.leftChild = newTree(node.leftChild, object);
        } else {
            node.rightChild = newTree(node.rightChild, object);
        }
        return node;
    }

    public List<V> preTraversal(TreeNode<V> root) {
        if (this == null) {
            return new ArrayList<>();
        } else {
            List<V> list = new ArrayList<>();
            list.add(root.getValue());
            if (root.leftChild != null) {
                list.addAll(preTraversal(root.leftChild));
            }
            if (root.rightChild != null) {
                list.addAll(preTraversal(root.rightChild));
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
                result.add(root.getValue());

                if (root.rightChild != null) {
                    stack.push(root.rightChild);
                }

                if (root.leftChild != null) {
                    stack.push(root.leftChild);

                }
            }
        }
        return result;
    }

}
