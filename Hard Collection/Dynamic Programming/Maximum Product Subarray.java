/* Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;    // global max
        int maxloc = 1, minloc = 1;     // max or min end here
        for (int num : nums) {          // negative could cause maxloc and minloc swap
            int prod1 = maxloc * num, prod2 = minloc * num;
            maxloc = Math.max(num, Math.max(prod1, prod2));
            minloc = Math.min(num, Math.min(prod1, prod2));
            max = Math.max(max, maxloc);
        }
        return max;
    }
}