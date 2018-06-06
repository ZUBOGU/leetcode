/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.
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
Create a dummy node. move the pointer to position m, then reverse the next n-m+1 ListNode.
Create the reverse LinkedList in place.
In the end, Connect 3 piece of the linked list adn return dummy.next.
Hanndler the corner case head == null and head.next == null
since 1 <= n=m <= n, we can return head.

Time complexity : O(n). 
Space complexity : O(1). constant space.
*/
