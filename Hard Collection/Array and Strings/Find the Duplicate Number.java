/* Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
 */

// Approach #1 Sorting [Accepted]
// O(n log n) time , O(n) space
/* class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
} */

// Approach #2 Set [Accepted]
// O(n) time , O(n) space
/* class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
 */
// Approach #3 Floyd's Tortoise and Hare (Cycle Detection) [Accepted]
// O(n) time , O(1) space
/* 
Algorithm
First off, we can easily show that the constraints of the problem imply that a cycle must exist. 
Because each number in nums is between 1 and n, it will necessarily point to an index that exists. 
Therefore, the list can be traversed infinitely, which implies that there is a cycle. 
Additionally, because 0 cannot appear as a value in nums, nums[0] cannot be part of the cycle. 
Therefore, traversing the array in this manner from nums[0] is equivalent to traversing a cyclic linked list. 
Given this, the problem can be solved just like Linked List Cycle II. 
*/
class Solution {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        // after do while loop we are in cycle, but not the begin of cycle

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}