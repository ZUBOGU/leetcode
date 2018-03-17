/*
Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (h.containsKey(curr)) {
                return true;
            } else {
                h.put(curr, 1);
            }
        }
        return false;
    }
}