/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m-1;
        int pointer2 = n-1;
        int pointer3 = m + n - 1;
        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[pointer3] = nums1[pointer1];
                pointer1--;
            } else {
                nums1[pointer3] = nums2[pointer2];
                pointer2--;
            }
            pointer3--;
        }
        while (pointer2 >= 0) {
            nums1[pointer3] = nums2[pointer2];
            pointer2--;
            pointer3--;
        }
    }
}