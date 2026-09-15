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

    int max_val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

       dfs_value(root);
       return max_val; 
       
    }
    public int dfs_value(TreeNode node){

        if(node == null){
            return 0;
        }

        // -ve overall for an node reduces the overall answer , so make it as ZERO...
        int left = Math.max(0 , dfs_value(node.left));
        int right = Math.max(0 , dfs_value(node.right));

        max_val = Math.max(max_val , node.val + left + right);

        // for every node we just need the max sum from that node
        return node.val + Math.max(left , right);
    }
}
