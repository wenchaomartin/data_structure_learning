package me.data.structure.learning.linknode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Solution19 {
    /**
     * test---1
     * 两个指针相差n 个step.何时 node!=null 何时node.next!=null ,我试了2次才能写对。让我想， 我怕想不来。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode firstPoint = head;
        ListNode otherPoint = head;
        while (n > 0) {
            otherPoint = otherPoint.next;
            n--;
        }
        ;
        //删除头结点的情况
        if (otherPoint == null) {
            return head.next;
        }

        while (otherPoint.next != null) {
            otherPoint = otherPoint.next;
            firstPoint = firstPoint.next;
        }
        firstPoint.next = firstPoint.next.next;
        return head;
    }


}