/*Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "null";
    private static int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(NN).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] arr = data.split(spliter);
        return buildTree(arr);
    }

    public TreeNode buildTree(String[] arr) {
        String p = arr[idx++];
        if (p.equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(p));
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));