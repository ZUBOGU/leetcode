/* Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2. */

// Use PQ
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                pq.offer(val);
                if(pq.size() > n * n - k + 1) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}

// Binary search. O(n log m). m = maxVal - minVal.
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    // Get count of int in matrix that is less than val.
    // matrix is sorted in ascending order 
    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            //get largest i that value <= val.
            if (matrix[i][j] > val) {
                i--;
            } else {
                //[i+1][j] is larger than val. Anything with higher i will larger than val.
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}