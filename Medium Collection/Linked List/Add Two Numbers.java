/*
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currList = new ListNode(0), dummyHead = currList;
        int carryBit = 0, left = 0, right = 0, currentValue = 0;
        while (l1 != null || l2 != null) {
        	left = (l1 != null) ? l1.val : 0;
        	right = (l2 != null) ? l2.val : 0;
        	currentValue = left + right + carryBit;
        	carryBit = currentValue / 10;
        	currList.next = new ListNode(currentValue % 10);
        	currList = currList.next;
        	if (l1 != null) l1= l1.next;
        	if (l2 != null) l2 = l2.next;
        }
        if (carryBit > 0) {
            currList.next = new ListNode(carryBit);
        }
        return dummyHead.next;
    }
}