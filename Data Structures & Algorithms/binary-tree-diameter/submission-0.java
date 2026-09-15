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
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return ans;
    }
    public int diameter(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = diameter(node.left);
        int right = diameter(node.right);

        ans = Math.max(ans , left + right);

        return 1 + Math.max(left , right);
    }
}
