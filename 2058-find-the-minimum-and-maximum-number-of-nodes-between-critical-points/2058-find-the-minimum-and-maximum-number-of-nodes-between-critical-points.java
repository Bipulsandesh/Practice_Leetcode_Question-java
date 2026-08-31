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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] arr=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        if(head.next.next==null)return arr;
        arr[0]=Integer.MAX_VALUE;
        int FirstCriticalPoint=-1,PreviousCriticalPoint=-1;
        int c=1;
        ListNode temp=head.next,prev=head;
        while(temp.next!=null){
            if((temp.val>temp.next.val && temp.val>prev.val) || (temp.val<temp.next.val && temp.val<prev.val)){
               FirstCriticalPoint=c; 
               PreviousCriticalPoint=c; 
               prev=temp;
               temp=temp.next;
               c++;
               break;
            }
            prev=temp;
            temp=temp.next;
            c++; 
        }
        while(temp.next!=null){
            if((temp.val>temp.next.val && temp.val>prev.val) || (temp.val<temp.next.val && temp.val<prev.val)){
               if(arr[0]>(c-PreviousCriticalPoint))arr[0]=c-PreviousCriticalPoint;
               PreviousCriticalPoint=c;
            }
            prev=temp;
            temp=temp.next;
            c++; 
        }
        if(arr[0]==Integer.MAX_VALUE){
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        arr[1]=PreviousCriticalPoint-FirstCriticalPoint;
        return arr;
    }
}