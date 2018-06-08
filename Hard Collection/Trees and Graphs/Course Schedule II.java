/* Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

 */

class Solution {
    //BFS. modify from Course Schedule.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       // Store the graph info. easier search later on
        ArrayList[] graph = new ArrayList[numCourses];

        int[] indegree = new int[numCourses];
        Queue queue = new LinkedList<Integer>();

        // add to ret if the course is taken. by the index.
        int[] ret = new int[numCourses];
        int index = 0;
        
        for(int i=0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        // Count indegree and out node for alll courses
        for(int i=0; i < prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        // Add degree 0 to the Queue. They are starting for BFS.
        for(int i=0; i < numCourses;i++){
            if( indegree[i] == 0){
                queue.add(i);
                ret[index] = i;
                index++;
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
                    ret[index] = nextCourse;
                    index++;
                }
            }
        }

        return (index != numCourses) ? new int[0] : ret;
    }
}