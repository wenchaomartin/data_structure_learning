import java.util.LinkedList;

public class BinNode<T> {
    private T data;

    BinNode parent, lChild, rChild;

    int height = 0;

    RBColor color;

    public BinNode(T data, BinNode parent, BinNode lChild, BinNode rChild, int height, RBColor color) {
        this.data = data;
        this.parent = parent;
        this.lChild = lChild;
        this.rChild = rChild;
        this.height = height;
        this.color = color;
    }

    public BinNode(T data) {
        this.data = data;
    }

    int size() {
        return count(this);
    }

    BinNode insertAsL(T e) {
        BinNode<T> binNode = new BinNode<>(e);
        this.lChild = binNode;
        binNode.parent = this;
        return binNode;
    }

    BinNode insertAsR(T e) {
        BinNode<T> binNode = new BinNode<>(e);
        this.rChild = binNode;
        binNode.parent = this;
        return binNode;
    }

    BinNode succ() {
        return null;
    }

    void travLevel() {
        LinkedList<BinNode> queue = new LinkedList<>();
        queue.addLast(this);
        while (queue.size() > 0) {
            System.out.println(queue.peek().data);
            queue.removeFirst();
            if (this.lChild != null) {
                queue.addLast(this.lChild);
            }
            if (this.rChild != null) {
                queue.addLast(this.rChild);
            }
        }
    }

    void travPre() {
        this.visitedPre(this);
    }

    void travIn() {
        this.visitedIn(this);
    }

    void travPost() {
        this.visitedPost(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinNode<?> binNode = (BinNode<?>) o;

        return data != null ? data.equals(binNode.data) : binNode.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    private int count(BinNode binNode) {
        int size = 0;
        if (binNode != null) {
            size++;
            return count(binNode.lChild) + count(binNode.rChild) + 1;
        } else {
            return size;
        }
    }

    private void visitedPre(BinNode binNode) {
        if (binNode != null) {
            System.out.println(binNode.data);
        }
        visitedPre(this.lChild);
        visitedPre(this.rChild);
    }

    private void visitedIn(BinNode binNode) {
        if (this.lChild != null) {
            visitedIn(this.lChild);
        }
        if (binNode != null) {
            System.out.println(binNode.data);
        }
        visitedIn(this.rChild);
    }

    private void visitedPost(BinNode binNode) {
        if (this.lChild != null) {
            visitedPost(this.lChild);
        }
        if (this.rChild != null) {
            visitedPost(this.rChild);
        }
        if (binNode != null) {
            System.out.println(binNode.data);
        }
    }
}
