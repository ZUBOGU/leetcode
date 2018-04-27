/*
Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
    	// binary search the min value
    	if (nums.length == 0)  return -1;

    	int low=0, high = nums.length -1;
    	while(low < high) {
    		int mid = (low + high) / 2;
    		if (nums[mid] > nums[high]) {
    			low = mid + 1;
    		} else {
    			high = mid;
    		}
    	}

    	int rotated = low;
    	low = 0;
    	high = nums.length -1;
    	while (low <= high) {
    		int mid = (low + high) / 2;
    		int realmid = (mid + rotated) % nums.length;
    		if (nums[realmid] == target) return realmid;
    		if (nums[realmid] < target) {
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	return -1; 
    }

}