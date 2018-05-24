/*
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

/*
Solution 1: 
Two Pass. First find length. Then, loop again and remove the nth val.

Time complexity : O(n).
Space complexity : O(1).
*/

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0, count2 = 0;
        ListNode pointer = head, pointer2 = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        int target = count - n - 1;
        if (target == -1) return head.next;
        while (count2 != target) {
            count2++;
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;
        return head;
    }
}

/*
Solution 2: 
One Pass. Move the fast pointer n steps. Then move both pointer.
When fast pointer.next == null. Slow pointer.next = next.next
Add dummy head, in case of remove the first node.

Time complexity : O(n).
Space complexity : O(1).
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
}