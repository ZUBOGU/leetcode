/* Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 */

//Approach 1: Brute force 
// O(n2) Time and O(1) space.
// Do as directed in question. For each element in the array, we find the maximum level of water it can trap after the rain, 
// which is equal to the minimum of maximum height of bars on both the sides minus its own height.

// Approach 2: Dynamic Programming
// // O(n2) Time and O(1) space.
// In brute force, we iterate over the left and right parts again and again just to find the highest bar size upto that index. 
// But, this could be stored. Voila, dynamic programming.

// Approach 3: Using stacks
class Solution {
    public int trap(int[] height) {
        
    }
}