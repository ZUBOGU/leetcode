/* Burst Balloons

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 

You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 

Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

    You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */

 // dp[i][j] means the maximal coins for range [i...j]. In this case, our final answer is dp[0][nums.length - 1].
 class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int[][] dp = new int[n+2][n+2];
        
        //re-create nums with edge being 1.
        int[] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i+1] = nums[i];
        }

        //Looping
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                //Loop for i, where i will be the last ballon to burst between start to end.
                for (int i = start; i <= end; i++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][i-1] + newNums[start-1]*newNums[i]*newNums[end+1] + dp[i+1][end]);
                }
            }
        }

        return dp[1][n];
    }
}