/* Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people.length == 1) return people;
        
        //if have same h, lower k is coming front
        //if have diff h, higher h is coming front.
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        ArrayList<int[]> tmp = new ArrayList<>();
        // For a given person to insert, all the people already sorted are higher.
        // So we just insert him in the "right" place to make the people before him as his "count" indicates. 
        // Curr person is shorter than all the people in the sorted list
        for (int[] p : people) {
            tmp.add(p[1], new int[]{p[0], p[1]});
        }
        
        return tmp.toArray(new int[people.length][2]);
    }
}