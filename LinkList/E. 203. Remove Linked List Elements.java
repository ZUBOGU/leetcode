/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
Find middle and reverse send half. 
Then, we can comapre the head and reversed send half to see if it is a Palindrome.
*/



/*
Complexity Analysis
Time complexity : O(n).

Space complexity: O(1). 
*/

