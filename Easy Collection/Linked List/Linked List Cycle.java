/*
Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode oneStep = head.next;
        ListNode twoStep = head.next.next;
    
        while(oneStep!=twoStep){
            if(twoStep ==null || twoStep.next==null) return false;
            // if(twoStep.next==null) return false;
            else{
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }
        }
        return true;
        
    }
}