/*
Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = new ArrayList<Integer>(), cur = null;
        for (int i = 0; i < numRows; i++) {
            cur = new ArrayList<Integer>();
            for (int j = 0 ; j <= i; j ++) {
                if (j == 0 || j == i) {
                    cur.add(j, 1);
                } else {
                    cur.add(j, pre.get(j) + pre.get(j-1));
                }
            }
            pre = cur;
            ret.add(cur);
        }
        return ret;
    }
}