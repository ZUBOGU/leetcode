/*Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : nums1) {
            hs.add(i);
        }
        HashSet<Integer> ls = new HashSet<Integer>();
        for (int i : nums2) {
            if (hs.contains(i)) {
                ls.add(i);
            }
        }
        int[] ret = new int[ls.size()];
        int index = 0;
        for (int i : ls) {
            ret[index] = i;
            index++;
        }
        return ret;
    }
}