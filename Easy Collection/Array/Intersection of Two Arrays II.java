/*
Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        
        HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
        for (int j : nums2) {
            hm2.put(j, hm2.getOrDefault(j, 0) + 1);
        }
        
        HashMap<Integer, Integer> hm3 = new HashMap<Integer, Integer>();
        for (int k : hm.keySet()) {
            if (hm2.containsKey(k)) {
                hm3.put(k, Math.min(hm.get(k), hm2.get(k)));
            }
        }
        
        int size = 0;
        for (int l: hm3.values()) {
            size += l;
        }
        
        int[] ret = new int[size];
        int index = 0;
        while (index < size) {
            for (int m : hm3.keySet()) {
                for (int n = 0; n < hm3.get(m); n++) {
                    ret[index] = m;
                    index++;
                }
            }
        }
        return ret;
        
    }
}