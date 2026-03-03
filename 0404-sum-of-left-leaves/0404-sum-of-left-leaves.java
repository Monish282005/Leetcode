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
    int sum = 0;
    public int sum(TreeNode root,boolean is){
        if(root == null) return 0;
        if(is && root.left == null && root.right == null){
           sum += root.val;
            return 0;
        }

        sum(root.left , true);
        sum(root.right , false);
        return sum;

    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) return sum;
        sum(root , true);
        return sum;
    }
}