/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Solution 1: 
Similar problem for odd even linked list.
Create a dummyHead to handle the first two node issue. Then, we can return dummyHead.next.
Consider switch first two. Then, we can just iterate to the end of linked list. It will use constant space.

Time complexity : O(n).
Space complexity : O(1).
*/

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead, nex = dummyHead.next;
        while (nex != null && nex.next != null) {
            curr.next = nex.next;
            curr = curr.next;
            nex.next = curr.next;
            curr.next = nex;
            curr = curr.next;
            nex = nex.next;
        }
        return dummyHead.next;
    }
}