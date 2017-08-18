/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
We create two dummy head. one keep the linked list with curr.val < x.
For the dummy2. one we found curr.val >= x. remove this node from dummy list,
inset into end of dummy2. 
In the end combine two dummy list into one list and return.

Time complexity : O(n).
Space complexity : O(1).
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy, curr2 = dummy2;
        while (curr != null) {
            if (curr.val < x) {
                prev = prev.next;
                curr = curr.next;
            } else {
                curr2.next = curr;
                prev.next = curr.next;
                curr = curr.next;
                curr2 = curr2.next;
                curr2.next = null;
            }
        }
        prev.next = dummy2.next;
        return dummy.next;
    }
}
