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



// root can be between -infinity to +infinity
// move LEFT : value should be less than root value : -infinity < node.val < root.val
//                                                  : subtreeroot.val < node.val < root.val

// move RIGHT : value should be greater than root value : root.val < node.val < +infinity 
//                                                      : root.val < node.val < subtreerooot.val
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
    public static boolean validate(TreeNode node , long left , long right){

        if(node == null){
            return true;
        }

        if(!(left < node.val && node.val < right)){
            return false;
        }

        // left move : vaal strictly lesser than root : right move : val strictly greater than root
        return validate(node.left , left , node.val) && validate(node.right , node.val , right);
    }
}
