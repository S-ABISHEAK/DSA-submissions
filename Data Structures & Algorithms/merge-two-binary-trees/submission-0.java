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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null){
            return null;
        }

        //get the two values of the trees ... SAME NODES 
        int value1 = (root1 != null) ? root1.val : 0;
        int value2 = (root2 != null) ? root2.val : 0;

        TreeNode new_node = new TreeNode(value1 + value2);

        // need to access the correct or parallel nodes in both trees

        new_node.left = mergeTrees(
            (root1 != null) ? root1.left : null , (root2 != null) ? root2.left : null
        );

        new_node.right = mergeTrees(
            (root1 != null) ? root1.right : null , (root2 != null) ? root2.right : null
        );

        return new_node;
    }
}