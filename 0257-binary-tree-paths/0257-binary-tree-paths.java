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
    boolean isLeaf = false;

    public void paths(TreeNode root, List<String> res, List<String> temp) {
        if (root == null)
            return;
        temp.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            String s = "";
            for (int i = 0; i < temp.size(); i++) {
                s += temp.get(i);
                if (i != temp.size() - 1)
                    s += "->";
            }
            res.add(s);
        } else {
            paths(root.left, res, temp);
            paths(root.right, res, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        paths(root, res, new ArrayList<String>());
        return res;
    }
}