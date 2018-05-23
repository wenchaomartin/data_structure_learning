public class BinNode<T> {
    private T data;

    BinNode parent,lChild,rChild;

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

    int size(){
        return 0;
    }

    BinNode insertAsL(BinNode binNode){
        return null;
    }

    BinNode insertAsR(BinNode binNode){
        return null;
    }

    BinNode succ(){
        return null;
    }

    void travLevel(){

    }

    void travPre(){

    }

    void travIn(){

    }

    void travPost(){

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
}
