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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        //BST - key > root.val then we traverse right
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            // This checks the right subtree of the key we wish to remove
            // and then finds the lowest value in the right subtree of the key
            // then places that value into the current root node
            TreeNode cur = root.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            // after reaching the lowest value in the right subtree then we choose 
            // to replace the current root.val with the cur.val 
            // then searching through the right subtree again we delete the node that is the same as the 
            // current root node
            root.val = cur.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}