/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Solution 1: 
Divide and Conquer
Find the mid and recurisve for left and right half.

Time complexity : O(n logn).
Space complexity : O(n logn).
*/

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode mid= findMiddle(head);
        TreeNode tree = new TreeNode(mid.val);
        tree.left = sortedListToBST(head);
        tree.right = sortedListToBST(mid.next);
        return tree;
    }
    
    // find the middle of Linked List. 
    // break the linked list linked list
    public ListNode findMiddle(ListNode head) {
        if(head.next == null) return head;
        ListNode fast = head, slow = head, slowprev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowprev = slow;
            slow = slow.next;
        }
        if (slowprev != null) slowprev.next = null;
        return slow;
        
    }
}