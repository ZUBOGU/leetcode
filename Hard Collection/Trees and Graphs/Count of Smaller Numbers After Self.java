import javafx.scene.Node;

/* Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. 

The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 */

/* Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication. 
For example, [3, 2, 2, 6, 1], from back to beginning,we would have:

                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
for example, if we insert 5, it should be inserted on the way down to the right of 3, 
the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4

if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5
 */
class Solution {
    private class Node {
        Node left, right;
        int val, leftSum, dup = 1; // sum is count of nodes in the left subtree.
        public Node(int v, int s) {
            val = v;
            leftSum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            //loop all nums and update the root.
            root = insertNode(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    Node insertNode(int val, Node root, Integer[] ans, int index, int preCount) {
        if (root == null) {
            //we find the position to insert. create the node with 0 leftSum.
            root = new Node(val, 0);
            ans[index] = preCount;
        } else if (val == root.val) {
            // Dup of current node. increase dup and update the ansewer
            root.dup++;
            ans[index] = preCount + root.leftSum;
        } else if (val < root.val) {
            // curr val is smaller. it will be insert to left of root.
            // left count increase.
            root.leftSum++;
            // insert to root left
            root.left = insertNode(val, root.left, ans, index, preCount);
        } else {
            // curr val is larger. it will be insert to right of root. 
            // the preCount need to add current root's leftSum and dup
            preCount += root.leftSum + root.dup;
            // recursive to the right with updated preCount.
            root.right = insertNode(val, root.right, ans, index, preCount);
        }
        return root;
    }
}