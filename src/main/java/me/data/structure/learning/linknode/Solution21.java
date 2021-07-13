package me.data.structure.learning.linknode;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;

    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        System.out.println(solution21.mergeTwoLists(ListNode.create(1, 2, 6), ListNode.create(3, 7, 8)));
    }
}
