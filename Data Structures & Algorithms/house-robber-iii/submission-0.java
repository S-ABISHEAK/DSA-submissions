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
    public int rob(TreeNode root) {

        int ans[] = dfs_rob(root);
        return Math.max(ans[0] , ans[1]);

    }
    public int[] dfs_rob(TreeNode node){

        if(node == null){
            return new int[]{0, 0};
        }

        int left_pair[] = dfs_rob(node.left);
        int right_pair[] = dfs_rob(node.right);

        /*
        with root : node itself and the without root parts of left and right coz 
        WITHOUT ROOT part of a node does not include teh node itself so it is like we are ignoring it and moving on with the next node
        */

        int with_root = node.val + left_pair[1] + right_pair[1];

        /*
        The WITHOUT ROOT paart involves selecting nodes that are not teh root and 
        even not the node adjecent to the root giving us multiple or the best possible solution
        */
        
        int without_root = Math.max(left_pair[0] , left_pair[1]) + Math.max(right_pair[0] , right_pair[1]);

        return new int[]{with_root , without_root};
    }
}