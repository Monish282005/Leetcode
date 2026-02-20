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
    int max = 0, val = 0;

    public void find(TreeNode root, int height) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && height > max) {
            val = root.val;
            max = height;
            return;
        }

        find(root.left, height + 1);
        find(root.right, height + 1);

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        find(root, 0);
        return val;
    }
}