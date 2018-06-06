/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
Solution 1: Reverse the linked list
Like Add two numbers. we reverse two linked list add them up.
Then, reverse it to the expected result.

Complexity Analysis

Time complexity : O(2(m+n)).
Space complexity : O(Max(m,n)).
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);
        int carry = 0;
        ListNode temp = n1;
        ListNode pre = n1;
        while(n1!= null || n2 != null || carry != 0){
            int v1 = n1 == null? 0: n1.val;
            int v2 = n2 == null? 0: n2.val;
            if(n1 == null){
                n1 = new ListNode((v1+v2+carry) % 10);
                pre.next = n1;
            }else{
                n1.val = (v1+v2+carry) % 10;
            }
            carry = (v1+v2+carry)/10;
            pre = n1;
            n1 = n1 == null? null : n1.next;
            n2 = n2 == null? null : n2.next;
        }
        return reverse(temp);
    }

    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}



/*
Solution 2: Not reverse the linked list
Using stack (dquene). Push all val into two stack then, pop
the value and create the return linked list from tail to head.


Complexity Analysis

Time complexity : O(2(m+n)).
Space complexity : O(m+n).
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode current = null;
        int carryon = 0;
        while (!s1.empty()||!s2.empty()) {
            int sum = 0;
            sum += carryon;
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            carryon = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = current;
            current = temp;
        }
        if (carryon != 0) {
            ListNode temp = new ListNode(carryon);
            temp.next = current;
            current = temp;
        }
        return current;        
    }
}

