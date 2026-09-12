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

    int count = 0;

    public int goodNodes(TreeNode root) {
        count_good(root , root.val);
        return count;
    }

    public void count_good(TreeNode root , int max_val){

        if(root  == null){
            return;
        }

        if(root.val >= max_val){
            count++;
        }

        count_good(root.left , Math.max(max_val , root.val));
        count_good(root.right , Math.max(max_val , root.val));
    }
}
