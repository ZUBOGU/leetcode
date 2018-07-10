/* Max Points on a Line

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;

        // The idea is for each point x, calculate the slope for cur and all other points.
        // If it has same slope, they are on same line.
        // For each point x, we store the Max Point for each x.
        // In the end, we just need to get Max of all point stored maxs
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < points.length; i++) {
            hm.clear();
            int samePoints = 1;
            int localMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    // Avoid using Double decimal value of slope.
                    int xDiff = points[j].y - points[i].y;
                    int yDiff = points[j].x - points[i].x;
                    // same point.                     
                    // Not add into hm. so skip loop
                    if (xDiff == 0 && yDiff == 0) {
                        samePoints++;
                        continue;
                    }
                    int gcd = generateGCD(xDiff, yDiff);
                    xDiff /= gcd;
                    yDiff /= gcd;
                    String key = xDiff+":"+yDiff;
                    if (hm.containsKey(key)) {
                        hm.put(key, hm.get(key)+1);
                    } else {
                        hm.put(key, 1);
                    }
                    localMax = Math.max(localMax, hm.get(key));
                }                
            }
            result = Math.max(result, localMax+samePoints);
        }
        return result;
    }

    private int generateGCD(int a,int b){
        return b == 0 ? a : generateGCD(b, a % b);     
    }
}