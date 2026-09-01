/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if we come across a null root then that is where we want to insert the 
        // val, so must create a new TreeNode(int val)
        if(root == null) return new TreeNode(val);

        //check if the val is greater than the current root, if so then go right
        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);  
        }
        //if val is less than current root then go left
        else if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        else {
            return root;
        }
        return root;
    }
}
