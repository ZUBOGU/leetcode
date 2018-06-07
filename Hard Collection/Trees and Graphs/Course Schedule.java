/* Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

 */

class Solution {
    // it is detecting if there is a cycle in graph.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Store the graph info. easier search later on
        ArrayList[] graph = new ArrayList[numCourses];

        int[] indegree = new int[numCourses];
        Queue queue = new LinkedList<Integer>();

        // count++ if the course is taken.
        int count=0;
        
        for(int i=0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        // Count indegree and out node for alll courses
        for(int i=0; i < prerequisites.length;i++){
            indegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        // Add degree 0 to the Queue. They are starting for BFS.
        for(int i=0; i < numCourses;i++){
            if( indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0) {
            int currentCourse = (int) (queue.remove());
            for (int i = 0; i < graph[currentCourse].size(); i++) {
                // Arraylist O(1) for access index.
                int nextCourse = (int) graph[currentCourse].get(i);
                // Current course has been taken. Count of indegree --;
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                    count++;
                }
            }
        }

        if(count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}