import java.util.PriorityQueue;

/* Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 

So the median is the mean of the two middle value. For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 */

class MedianFinder {

    PriorityQueue<Double> lo;
    PriorityQueue<Double> hi;
    boolean even = true;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<Double>(Collections.reverseOrder());
        hi = new PriorityQueue<Double>();
    }
    
    public void addNum(int num) {
        if (even) {
            hi.offer(num+0.0);
            lo.offer(hi.poll());
        } else {
            lo.offer(num+0.0);
            hi.offer(lo.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (lo.peek() + hi.peek()) / 2.0;
        } else {
            return lo.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */