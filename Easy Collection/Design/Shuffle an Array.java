/*
Shuffle an Array

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

// Check https://www.geeksforgeeks.org/shuffle-a-given-array/
class Solution {
	int[] nums;
	int size = 0;

    public Solution(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int[] rand =  nums.clone();
        for (int i = 1; i < size; i++) {
			int j =  random.nextInt(i+1);
			int temp = rand[i];
			rand[i] = rand[j];
			rand[j] = temp;
		}
        return rand;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */