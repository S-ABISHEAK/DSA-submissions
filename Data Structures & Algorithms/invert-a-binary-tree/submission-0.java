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

 //WITH SIMPLE DEPTH DIRST SEARCH : PERFORM SWAP OF 2 NUMBERS TECHNIQUE AND DFS ON LEFT AND THEN RIGHT 

class Solution {
    public TreeNode invertTree(TreeNode root) {
       
       if(root == null){
        return root;
       }

       // swap logic
       TreeNode temp = root.left;
       root.left = root.right;
       root.right = temp;

       invertTree(root.left);
       invertTree(root.right);

       return root;
    }
}
