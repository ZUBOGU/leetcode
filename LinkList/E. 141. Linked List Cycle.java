/*
Given a linked list, determine if it has a cycle in it.

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
Solution 1: Approach #1 (Hash Table) [Accepted]
We go through each node one by one and record each node's reference (or memory address) in a hash table.
If the current node is null, we have reached the end of the list and it must not be cyclic.
If current node’s reference is in the hash table, then return true.
*/
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}
/*
Complexity Analysis
Time complexity : O(n). We visit each of the nn elements in the list at most once. Adding a node to the hash table costs only O(1) time.

Space complexity: O(n). The space depends on the number of elements added to the hash table, which contains at most nn elements.
*/

/*
Solution 2: Approach #2 (Two Pointers) [Accepted]

Imagine two runners running on a track at different speed. What happens when the track is actually a circle?

Algorithm

The space complexity can be reduced to O(1) by considering two pointers at different speed - a slow pointer and a fast pointer. 

The slow pointer moves one step at a time while the fast pointer moves two steps at a time.

If there is no cycle in the list, the fast pointer will eventually reach the end and we can return false in this case.

Now consider a cyclic list and imagine the slow and fast pointers are two runners racing around a circle track. 

The fast runner will eventually meet the slow runner. Why? Consider this case (we name it case A) - The fast runner is just one step behind the slow runner. 

In the next iteration, they both increment one and two steps respectively and meet each other.

How about other cases? For example, we have not considered cases where the fast runner is two or three steps behind the slow runner yet. 

This is simple, because in the next or next's next iteration, this case will be reduced to case A mentioned above.

*/
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}

/*
Complexity Analysis
Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).

Space complexity : O(1).
*/