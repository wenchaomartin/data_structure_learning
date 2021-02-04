package me.data.structure.learning.tree.node;

/**
 * Create by songwenchao on 2019-09-01
 */
public class TreeNode<T extends Comparable<T>> implements Comparable<T> {

    public T val;

    public TreeNode<T> left;

    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public int compareTo(T o) {
        return this.val.compareTo(o);
    }


}
