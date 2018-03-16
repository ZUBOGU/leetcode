/* 
Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0, count2 = 0;
        ListNode fastpointer = dummy, slowpointer = dummy;
        for (int i = 0; i < n; i++) {
            fastpointer = fastpointer.next;
        }
        while (fastpointer.next != null) {
            fastpointer = fastpointer.next;
            slowpointer = slowpointer.next;
        }
        slowpointer.next = slowpointer.next.next;
        return dummy.next;
    }
}