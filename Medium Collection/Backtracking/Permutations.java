/*
Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	int first = nums[0];
    	if (nums.length == 1) {
    		List<Integer> re = new ArrayList<Integer>();
            re.add(first);
    		ret.add(re);
            return ret;
    	}
    	for (List<Integer> l : permute(Arrays.copyOfRange(nums, 1, nums.length))) {
    		int len = l.size();
    		for (int i = 0; i < len+1; i++) {
    			List<Integer> cur = new ArrayList<Integer>(l);
    			cur.add(i, first);
    			ret.add(cur);
    		}
    	}
        return ret;
    }
}