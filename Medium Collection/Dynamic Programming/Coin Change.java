/*
Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 
*/

// Top down DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int amount, int[] count) {
    	if (amount < 0) return -1;
    	if (amount == 0) return 0;
    	if (count[amount - 1] != 0) return count[amount - 1];

    	int min = Integer.MAX_VALUE;
    	for (int coin : coins) {
    		int res = coinChange(coins, amount - coin, count);
    		if (res >= 0 && res < min) {
    			min = res + 1;
    		}
    	}
    	count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    	return count[amount - 1];
    }
}

// Botton up DP
class Solution {
    public int coinChange(int[] coins, int amount) {
    	int max = amount + 1;
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp, max);
    	dp[0] = 0;
    	for (int i = 1; i <= amount; i++) {
    		for (int j = 0; j < coins.length; j++) {
    			if (coins[j] <= i) {
    				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
    			}
    		}
    	}
    	return dp[amount] > amount ? -1 : dp[amount];
	}
}