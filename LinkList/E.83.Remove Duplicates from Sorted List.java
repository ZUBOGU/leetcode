/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
Solution 1: Straight-Forward Approach
Check curr and curr.next. If equal, change curr.next to next.next
otherwise, not equal and it is a sorted linked list. we can move curr to curr.next.
Then iterate.
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;       
    }
}


/*
Complexity Analysis
Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).

Space complexity : O(1).
*/