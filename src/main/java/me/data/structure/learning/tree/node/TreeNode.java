package me.data.structure.learning.tree.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by songwenchao on 2019-09-01
 */
public class TreeNode<T extends Comparable<T>> implements Comparable<T> {

    private T value;

    TreeNode<T> leftChild;

    TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int compareTo(T o) {
        return this.value.compareTo(o);
    }


}
