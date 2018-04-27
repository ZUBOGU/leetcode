/*
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        
        int size = intervals.size();
        //sort
        Interval[] intervalArray = intervals.toArray(new Interval[size]);
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Arrays.sort(intervalArray, comparator);

   
        //merge
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = intervalArray[0];
        for (int i = 1; i < size; i++) {
            if (prev.end < intervalArray[i].start) {
                result.add(prev);
                prev = intervalArray[i];
            } else {
                prev.end = Math.max(prev.end, intervalArray[i].end);
            }
        }
        result.add(prev);
        return result;
    }
}