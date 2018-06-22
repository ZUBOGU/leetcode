/* Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

   // I can sort and re arrange the array which is O(n log n)
 // Better solution find Middle and do in-place swap.
 // The newIndex method is the key. To find the right index to replace.
 class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
			return;
        } 
        int n = nums.length;

        // Assume this is O(n) space and O(1) time.
        // Step 1: Find the median  
        int median = findKthLargest(nums, (n + 1) / 2);

        // Step 2: partition within O(n)-time & O(1)-space. 
        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            if (nums[newIndex(mid,n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(mid++,n));
            }
            else if (nums[newIndex(mid,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(mid,n));
            }
            else {
                mid++;
            }
        }
    }

    private int newIndex(int index, int n) {
        // where (n | 1) calculates the nearest odd that is not less than n.
        return (1 + 2*index) % (n | 1);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
      }

	public int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}