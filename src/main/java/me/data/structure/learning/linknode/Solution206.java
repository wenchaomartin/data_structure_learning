package me.data.structure.learning.linknode;

public class Solution206 {
    //头插法
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        ListNode current = new ListNode(head.val);
        ListNode previous = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            previous = new ListNode(head.val);
            previous.next = current;
            current = previous;
        }
        return previous;

    }

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //倒数第二个节点
        ListNode current = reverseList(head.next);
        //head.next 倒数第一个节点
        head.next.next = head;
        //断开连接
        head.next = null;
        return current;
    }


}