/*Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

// HashMap 
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> table =  new HashMap<Integer, Integer>();
        for (int e: nums) {
            if (table.get(e) == null) {
                table.put(e, 1);
            } else {
                table.put(e, table.get(e) + 1);
            }
        }
        int length = nums.length;
        int returnvalue = 0;
        for (int key : table.keySet()) {
            if (table.get(key) * 2 > length) {
                returnvalue = key;
            }
        }
        return returnvalue;
    }
}

// Sorting 
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}