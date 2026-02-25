
class Solution {
    public int find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.val == p.val || root.val == q.val)
            return root.val;

        int left = find(root.left, p, q);
        int right = find(root.right, p, q);

        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE)
            return root.val;
        if (left != Integer.MIN_VALUE)
            return left;
        if (right != Integer.MIN_VALUE)
            return right;

        return Integer.MIN_VALUE;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return new TreeNode(find(root, p, q));

    }
}