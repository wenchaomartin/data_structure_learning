package me.data.structure.learning.linknode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return accum(this);
    }

    private String accum(ListNode node) {
        if (node == null) return null;
        return node.val + accum(node.next);
    }

    /**
     * dfs
     *
     * @param values
     * @return
     */
    public static ListNode create(int... values) {
        return build(values, 0, values.length);
    }

    /**
     * 递归 难点他是动态的， 人脑的记忆往往是图片式的。所以学递归要看动态图
  * @param values
     * @param i
     * @param size
     * @return
     */
    private static ListNode build(int[] values, int i, int size) {
        if (i == size) {
            return null;
        }
        ListNode node = new ListNode(values[i]);
        i = i + 1;
        node.next = build(values, i, size);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.create(1, 2, 3));
    }
}