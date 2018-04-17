/*
Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursively 
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> re = new ArrayList<Integer>();
        if (root == null) {
            return re;
        }
        
        if (root.left != null) {
            ArrayList<Integer> left = (ArrayList<Integer>) inorderTraversal(root.left);
            for (int integer : left) {
                re.add(integer);
            }
        }

        re.add(root.val);

        if (root.right != null) {
            ArrayList<Integer> right = (ArrayList<Integer>) inorderTraversal(root.right);
            for (int integer : right) {
                re.add(integer);
            }
        }
        return re;
    }
}

// Stack
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr =root
        while (curr != null || !s.isEmpty()) {
        	while (cur != null) {
        		s.push(curr);
        		curr = curr.left
        	}
        	curr = s.pop()
        	re.add(curr.val)
        	curr = curr.right
        }
        return re
    }
}