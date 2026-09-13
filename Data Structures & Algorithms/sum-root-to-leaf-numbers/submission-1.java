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
    public int sumNumbers(TreeNode root) {
        
        return calc_dfs(root , 0);
    }
    public static int calc_dfs(TreeNode root , int value){
        
        if(root == null){
            return 0;
        }

        value = value * 10 + root.val;

        if(root.left == null && root.right == null){
            return value;
        }

        return calc_dfs(root.left , value) + calc_dfs(root.right , value);
    }
}