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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // IF BOTH THE p AND q ARE NULL  : TRUE

        if(p == null && q == null){
            return true;
        } 
        // IF ONLY ANY ONE OF THEM IS NULL : FALSE

        if(p == null || q == null){
            return false;
        }

        // NOW CHECK THE VALUES 

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }
}
