/* Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit. 

index at 2 & 3 form one height 5 rectangle given 5 * 2 = 10 area.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

// the idea is that:
// For each bar, take its height as the rectangle's height. Then find the left and right boundaries of this rectangle.
// (The second top bar in stack) is always the first bar lower than (the top bar in stack) on the left.
// (The bar that i points to) is always the first bar lower than (the top bar in stack) on the right.
// After step 2 and 3, we know the left and right boundaries, then know the width, then know the area.

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // Stack will contain a increase heights seen so far.
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        //Loop to len, and given index = len height 0, So we can clean up whole stakc, not missing anything
        for(int i = 0; i <= len; i++){
            //When i == len, set h = 0, if will be the lowerest height and we can loop for rest stack
            int h = (i == len ? 0 : heights[i]);
            // If current height for i is higher, push to stack
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                //Current height for i is lower than top of stack
                //We pop out top as smaller height, then calcluate the area
                int tp = s.pop();
                // i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >= height[tp], 
                // because the index on top of the stack right now is the first index left of tp with height smaller than tp's height.
                // For the above sample, we get 6 * 1 first, i = 4, s.peek() + 1 = 3, the correct left and right boundary for height 6.
                // Then, second loop, we get 5 * 2, i = 4, s.peek() + i = 2, right bounaries.   
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                //Don't want to move i, so we adjust it.
                i--;
            }
        }
        return maxArea;
    }
}