/*
Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ret = {0,0};
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                int[] result = {map.get(nums[i]),i};
                return result;
            }
            map.put(target-nums[i], i);
        }
        return ret;
    }
}