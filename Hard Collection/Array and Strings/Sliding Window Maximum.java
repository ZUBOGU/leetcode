/* Sliding Window Maximum

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int left = 0, right = 0;

        while(right < nums.length){

            //so that we consider k values at a time to find max
            while (right <= left + k-1){
                // Push operation - Delete all elements in Deque that
                // are strictly less than the one we are now pushing.
                while(!deque.isEmpty()  && deque.peekLast() < nums[right]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[right++]);
            }
            if( right == left+k){
                result[left] = deque.peekFirst();
                //If the front of the deque is equal to
                // the front of the queue (nums[left] here) then from Deque
                // Remove the left max from deque if it is the first one in deque
                if(nums[left]== deque.peekFirst())
                    deque.pollFirst();
                left++;
            }

        }
        return result;
    }
}