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
    public int find(int val, TreeNode root, int height) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && height == val)
            return root.val;

        return find(val, root.left, height + 1) + find(val, root.right, height + 1);

    }

    public int findHeight(TreeNode root, int height) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return height;

        int left = findHeight(root.left, height + 1);
        int right = findHeight(root.right, height + 1);

        return Math.max(left, right);

    }

    public int deepestLeavesSum(TreeNode root) {
        int maxHeight = findHeight(root, 0);
        return find(maxHeight, root, 0);
    }
}