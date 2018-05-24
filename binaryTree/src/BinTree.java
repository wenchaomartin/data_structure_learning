public abstract class BinTree<T> {
    private int size;

    private BinNode<T> root;

    abstract int updateHeight(BinNode<T> node);

    void updateHeightAbove(BinNode<T> node) {

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

    }

    BinTree<T> attachAsRC(BinNode<T> binNode, BinTree<T> binTree) {

    }

    int remove(BinNode<T> binNode) {

    }
}
