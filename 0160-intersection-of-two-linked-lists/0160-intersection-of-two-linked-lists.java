/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        // If either list is empty, there can be no intersection
        if (A == null || B == null) {
            return null;
        }

        // Calculate the lengths of both lists
        ListNode temp1 = A;
        ListNode temp2 = B;
        int l1 = 0, l2 = 0;
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }

        // Reset the pointers to the heads of the lists
        temp1 = A;
        temp2 = B;

        // Move the pointer of the longer list ahead by the difference in lengths
        int count = 0;
        if (l1 > l2) {
            count = l1 - l2;
            while (count > 0) {
                temp1 = temp1.next;
                count--;
            }
        } else {
            count = l2 - l1;
            while (count > 0) {
                temp2 = temp2.next;
                count--;
            }
        }

        // Traverse both lists simultaneously and check for intersection
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1; // Intersection point
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // No intersection found
        return null;
    }
}