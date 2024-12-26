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

    private ListNode[] reverseList(ListNode head, int k)
    {
        ListNode curr = head;
        ListNode prev = null, next = null;

       for(int i = 0; i < k; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 

        return new ListNode[] {prev, curr};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ptr = dummy;

        while(ptr != null)
        {
           ListNode tracker = ptr;

           for(int i = 0; i < k; i++)
           {
            if(tracker == null) break;

            tracker = tracker.next;
           }

        if (tracker == null) {
            break;
            }

           ListNode[] reversedData = reverseList(ptr.next, k);

           ListNode prev = reversedData[0];
           ListNode curr = reversedData[1];

           ListNode lastNodeOfReversedGroup = ptr.next;


           lastNodeOfReversedGroup.next = curr;

           ptr.next = prev;

           ptr = lastNodeOfReversedGroup;
           
        }

        return dummy.next;
    }
        }