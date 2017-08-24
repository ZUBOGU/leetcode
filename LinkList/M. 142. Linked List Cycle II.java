/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
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
Assume cycle begin at position A and slow point meet fast point after travel B length.
And fast point must have travelled 2A+2B. fast is 2 times speed than slow.
Assume N is the difference. Than A + B + N = 2A + 2B
N = A + B. N must be the times of cycle length.
We know slow point has travel B legth in the cycle. if slow point travels A legnth again,
it will return to the begin of the cycle which is we wanted.
We move fast to head. if fast travel to the begin of cycle, it will meet slow again. 
Thus we have condition while(slow != fast).

Time complexity : O(n). 
Space complexity : O(1). constant space.
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

