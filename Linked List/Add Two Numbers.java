/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
Using dummy head and carry on int. loop from left to right for both linked list

Complexity Analysis:

Time complexity : O(max(m,n)).
Space complexity : O(max(m,n)).
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode returnList = new ListNode(0);
        ListNode head = returnList;
        int comeFromBefore = 0;
        int left;
        int right;
        int currentValue;
        do {
            if (l1 == null) {
                left = 0;
            } else {
                left = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                right = 0;
            } else {
                right = l2.val;
                l2 = l2.next;
            }
            
            currentValue = left + right + comeFromBefore;
            if (currentValue >= 10) {
                comeFromBefore = currentValue / 10;
            } else {
                comeFromBefore = 0;
            }
            returnList.next = new ListNode(currentValue % 10);
            returnList = returnList.next;

        } while (l1 != null || l2 != null || comeFromBefore != 0);

        return head.next;
        
    }
}

// version: 高频题班
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
            int sum = carry;
            sum += (i != null) ? i.val : 0;
            sum += (j != null) ? j.val : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            i = (i == null) ? i : i.next;
            j = (j == null) ? j : j.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
}