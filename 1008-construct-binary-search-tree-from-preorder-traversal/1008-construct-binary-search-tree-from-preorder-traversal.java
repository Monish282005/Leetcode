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
    public TreeNode append(int val, TreeNode root) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val)
            root.left = append(val, root.left);
        else
            root.right = append(val, root.right);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        for (int i : preorder) {
            if (root == null)
                root = new TreeNode(i);
            else
                append(i, root);
        }

        return root;
    }
}