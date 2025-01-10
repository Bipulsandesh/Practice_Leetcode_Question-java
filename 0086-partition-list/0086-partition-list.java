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
    public ListNode partition(ListNode head, int x) {
        ListNode  first = null;
        ListNode second = null;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val>=x){
                ListNode newnode = new ListNode(temp.val);
                newnode.next = null;
                if(second==null){
                    second = newnode;
                    newnode.next = null;
                }else{
                    ListNode temp2 = second;
                    while(temp2.next!=null){
                        temp2= temp2.next;
                    }
                    temp2.next = newnode;
                }
            }else{
                ListNode newnode = new ListNode(temp.val);
                newnode.next = null;
                 if(first==null){
                    first = newnode;
                    newnode.next = null;
                }else{
                    ListNode temp2 = first;
                    while(temp2.next!=null){
                        temp2= temp2.next;
                    }
                    temp2.next = newnode;
                }
            }
            temp =temp.next;
        }
        ListNode temp2 = first;
                if(first==null){
                    return second;
                }else if(second==null){
                    return first;
                }else if(first==null&&second==null){
                    return first;
                }else{
                    while(temp2.next!=null){
                        temp2= temp2.next;
                    }
                    temp2.next = second;
    return first;
                }
                    
    }
}