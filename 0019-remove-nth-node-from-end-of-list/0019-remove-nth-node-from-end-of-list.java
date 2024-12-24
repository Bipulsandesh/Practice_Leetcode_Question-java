/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        while (n > 0) {
            n--;
            first = first.next;
        }
        if (first == null)
            return head.next;
        ListNode second = head;
        while (first.next!= null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}