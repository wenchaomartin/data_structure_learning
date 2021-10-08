package me.data.structure.learning.linknode;

/**
 * 链表的两数相加
 */
public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode previous = new ListNode(0);
        ListNode current = previous;
        int carry = 0, n1 = 0, n2 = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return previous.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.create(1, 2, 6);
        ListNode l2 = ListNode.create(9);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
