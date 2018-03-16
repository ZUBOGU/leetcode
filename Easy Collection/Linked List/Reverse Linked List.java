/*
Reverse Linked List

Reverse a singly linked list.

click to show more hints.
Hint:

A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head) {
        if(head == null)    return head;
        ListNode slow=null, mid=null, fast=head;
        while(fast != null){
            slow = mid;
            mid = fast;
            fast = fast.next;
            mid.next = slow;
        }
        return mid;
    }
}