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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //CHECK FOR SAME TREE : ON EVVERY POSSIBLE NODE...
       
        // return check_equal(root , subRoot) || check_equal(root.left , subRoot) || check_equal(root.right , subRoot);
         if (root == null) {
            return false;
        }

        // first check if the subtree is there with the root : then mode to the left and right to to perform te same check first then and then move
        if (check_equal(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public static boolean check_equal(TreeNode node , TreeNode sub_node){

        if(node == null && sub_node == null){
            return true;
        }

        if(node == null || sub_node == null){
            return false;
        }

        if(node.val != sub_node.val){
            return false;
        }

        return check_equal(node.left , sub_node.left) && check_equal(node.right , sub_node.right);
    }
}
