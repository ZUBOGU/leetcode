/*
Reverse a singly linked list.
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
Solution 1: change current listNode as the next listnode's next. then iterative
*/
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

/*
Complexity Analysis
Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).

Space complexity : O(1).
*/


/*
Solution 2: recursive. Assuming n_k-1 to n_1 is reverse. special handle n_1. NOT RECOMMEND
*/
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

/*
Complexity Analysis
Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).

Space complexity : O(n). he extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
*/
