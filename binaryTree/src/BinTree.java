public abstract class BinTree<T> {
    private int size;

    private BinNode<T> root;

    int updateHeight(BinNode<T> node) {
        return node.height = height(node);
    }

    void updateHeightAbove(BinNode<T> node) {
        while (node != null) {
            updateHeight(node);
            node = node.parent;
        }
    }

    public BinTree() {
    }

    int size() {
        return size;
    }

    boolean empty() {
        return root == null ? true : false;
    }

    BinNode<T> root() {
        return root;
    }

    BinNode<T> insertAsRoot(T e) {
        this.size = 1;
        BinNode<T> binNode = new BinNode(e);
        root = binNode;
        return root;
    }

    BinNode<T> insertAsLC(BinNode<T> binNode, T e) {
        size++;
        binNode.insertAsL(e);
        updateHeightAbove(binNode);
        return binNode.lChild;
    }

    BinNode<T> insertAsRC(BinNode<T> binNode, T e) {
        size++;
        binNode.insertAsR(e);
        updateHeightAbove(binNode);
        return binNode.rChild;
    }

    BinTree<T> attachAsLC(BinNode<T> binNode, BinTree<T> binTree) {
        binNode.lChild = binTree.root;
        binTree.root.parent = binNode;
        binTree = null;
        size += binTree.size;
        binNode.height += binTree.root.height;
        updateHeightAbove(binNode);
        return this;
    }

    BinTree<T> attachAsRC(BinNode<T> binNode, BinTree<T> binTree) {
        binNode.rChild = binTree.root;
        binTree.root.parent = binNode;
        binTree = null;
        size += binTree.size;
        binNode.height += binTree.root.height;
        updateHeightAbove(binNode);
        return this;
    }

    int remove(BinNode<T> binNode) {

    }

    int height(BinNode<T> binNode) {
        if (binNode == null) {
            return -1;
        } else {
            int lHeight = height(binNode.lChild);
            int rHeight = height(binNode.rChild);
            return Math.max(lHeight, rHeight) + 1;
        }
    }
}
