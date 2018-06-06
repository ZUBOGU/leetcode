/*
Sort a linked list using insertion sort.
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
We are using insertion. So we loop for each Node in linked list and insert into dummy head.
We have two pointer, prev and pointer(curr position in return list). Compare the value and put
the node into right place. 

Time complexity : O(n).
Space complexity : O(1).
*/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head, prev;
        while (curr != null) {
            ListNode pointer = dummy.next;
            prev = dummy;
            while (pointer != null && pointer.val < curr.val) {
                pointer = pointer.next;
                prev = prev.next;
            }  
            prev.next = curr;
            curr = curr.next;
            prev.next.next = pointer;
        }
        return dummy.next;
        
    }
}
