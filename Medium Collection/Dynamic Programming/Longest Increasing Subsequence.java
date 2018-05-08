/*Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? */

//Approach #1 Brute Force [Time Limit Exceeded] Time: O(2^n); Space: O(n^2).
// public class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return lengthofLIS(nums, Integer.MIN_VALUE, 0);
//     }

//     public int lengthofLIS(int[] nums, int prev, int curpos) {
//         if (curpos == nums.length) {
//             return 0;
//         }
//         // find max from take or not taken current position
//         int taken = 0;
//         if (nums[curpos] > prev) {
//             taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
//         }
//         int nottaken = lengthofLIS(nums, prev, curpos + 1);
//         return Math.max(taken, nottaken);
//     }
// }


// Approach #2 Recursion with memorization [Memory Limit Exceeded] Time: O(n^2); Space: O(n^2).
// public class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int memo[][] = new int[nums.length + 1][nums.length];
//         for (int[] l : memo) {
//             Arrays.fill(l, -1);
//         }
//         return lengthofLIS(nums, -1, 0, memo);
//     }
//     public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
//         if (curpos == nums.length) {
//             return 0;
//         }
//         if (memo[previndex + 1][curpos] >= 0) {
//             return memo[previndex + 1][curpos];
//         }
//         int taken = 0;
//         if (previndex < 0 || nums[curpos] > nums[previndex]) {
//             taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
//         }

//         int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
//         memo[previndex + 1][curpos] = Math.max(taken, nottaken);
//         return memo[previndex + 1][curpos];
//     }
// }

// Approach #3 Dynamic Programming [Accepted]. Time: O(n^2); Space: O(n).
// dp[i]=max(dp[j])+1,∀0≤j<i
// At the end, the maximum out of all the dp[i]'s to determine the final result.
// LIS​length​​=max(dp[i]),∀0≤i<n

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

// Approach #4 Dynamic Programming with Binary Search[Accepted]: Time: O(n*log(n)); Space: O(n).

// public class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
//         int len = 0;
//         for (int num : nums) {
//             int i = Arrays.binarySearch(dp, 0, len, num);
//             if (i < 0) {
//                 i = -(i + 1);
//             }
//             dp[i] = num;
//             if (i == len) {
//                 len++;
//             }
//         }
//         return len;
//     }
// }