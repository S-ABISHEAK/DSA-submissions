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

// INORDER in an BST creates the overall system to 
class Solution {
    
    int count = 0;
    TreeNode ans_node = new TreeNode();

    public int kthSmallest(TreeNode root, int k) {

        inorder(root , k);
        return ans_node.val;
        
    }
    public void inorder(TreeNode node , int k){

        if(node == null){
            return ;
        }

        inorder(node.left , k);

        count++;
        if(count == k){
            ans_node = node;
            return;
        }
        inorder(node.right , k);
    }

}
