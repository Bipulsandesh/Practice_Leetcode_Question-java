/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list and the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // Step 2: Handle cases where k >= length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Find the breaking point
        int breakPoint = length - k;
        ListNode current = head;
        for (int i = 1; i < breakPoint; i++) {
            current = current.next;
        }

        // Step 4: Rotate the list
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }
}