/*
Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2

Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8


Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (1 + length) * length / 2;
        for (int num: nums) {
            sum -= num;
        }
        return sum;
    }
}

// bitwise operation
public class Solution {
    public int missingNumber(int[] nums) {
        int ret = nums.length;
        for (int i =0;i < nums.length; i++) {
            ret ^= i ^ nums[i];
        }
        return ret;
    }
}