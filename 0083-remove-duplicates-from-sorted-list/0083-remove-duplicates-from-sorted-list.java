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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode temp2 = head.next;
        int last = head.val;
        while(temp2 != null){ // while end of Linked list
            if(temp2.val == last){ // Current number same to last number
                if(temp2.next == null){ // If last element, just delete and break loop
                    temp.next = null;
                    break;
                }
                temp2 = temp2.next; // Not last, then delete that element
                temp.next = temp2; // and move to next element
            }
            else{ // If not the same as last element, jump to next node
                temp = temp2; 
                last = temp.val;
                temp2 = temp2.next;
            }
        }
        return head; // return the head back
    }

}