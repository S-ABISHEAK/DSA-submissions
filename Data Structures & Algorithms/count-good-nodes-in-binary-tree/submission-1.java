// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// class Solution {

//     int count = 0;

//     public int goodNodes(TreeNode root) {
//         count_good(root , root.val);
//         return count;
//     }

//     public void count_good(TreeNode root , int max_val){

//         if(root  == null){
//             return;
//         }

//         if(root.val >= max_val){
//             count++;
//         }

//         // pass down the max value when we move from top to bottom through left and right
//         count_good(root.left , Math.max(max_val , root.val)); 
//         count_good(root.right , Math.max(max_val , root.val));
//     }
// }


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

    public int goodNodes(TreeNode root) {
        
        return count_good(root , root.val);
        
    }

    public int count_good(TreeNode root , int max_val){

        // move from top -> left -> right : PREORDER. maintain max from top to bottom
        if(root  == null){
            return 0;
        }
        
        int count = 0;

        if(root.val >= max_val){
            count = 1;
        }

        // pass down the max value when we move from top to bottom through left and right
        int left = count_good(root.left , Math.max(max_val , root.val)); 
        int right = count_good(root.right , Math.max(max_val , root.val));

        return count + left + right;
    }
}

