/*
House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
class Solution {
    public int rob(int[] nums) {
    	int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] dp = new int[length+1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < length + 1; i++) {
        	dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[length];
    }
}