/*
Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	ret.add(new ArrayList<Integer>());
    	for (int i : nums) {
    		List<List<Integer>> curr = new ArrayList<List<Integer>>();
    		for (List<Integer> l : ret) {
                List<Integer> currl = new ArrayList<Integer>(l);
                currl.add(i);
    			curr.add(currl);
    		}
            ret.addAll(curr);
    	}
    	return ret;
    }
}