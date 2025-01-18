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
    public static ListNode reverse(ListNode head){
        ListNode newhead = null;
        ListNode temp = head;
        ListNode temp2 = null;  // Initialize temp2 outside the loop

        while (temp != null) {
            temp2 = temp;          // Store the current node in temp2
            temp = temp.next;      // Move temp to the next node
            temp2.next = newhead;  // Reverse the link by pointing temp2.next to newhead
            newhead = temp2;       // Move newhead to the current node (temp2)
        }

        return newhead;  // newhead is the new head of the reversed list
    }
    public static ListNode merge(ListNode head1, ListNode head2 ){
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(head1!=null && head2!=null){
           tail.next=head1;
           head1=head1.next;
           tail=tail.next;
           tail.next=head2;
           head2=head2.next;
           tail=tail.next;
        }
        while(head1!=null){
            tail.next=head1;
            head1=head1.next;
            tail=tail.next;
        }
        while(head2!=null){
            tail.next=head2;
            head2=head2.next;
            tail=tail.next;
        }
        tail.next=null;
        return dummy.next;
    }
    public void reorderList(ListNode head) {
         // Find the middle of the list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode mid = slow.next;
        slow.next = null;//diconnecting the first list from the second
        ListNode first=head;
        ListNode second=reverse(mid);
        head=merge(first,second);
    }
}