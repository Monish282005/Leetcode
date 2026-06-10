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
    ArrayList<TreeNode> list = new ArrayList<>();

    public void inOrder(TreeNode root){
        if(root == null)
            return;

        inOrder(root.left);
        list.add(root);
        inOrder(root.right);

    }
    public TreeNode increasingBST(TreeNode root) {
       inOrder(root);

       for(int i = 0; i < list.size() - 1; i++){
            TreeNode prev = list.get(i);
            TreeNode next = list.get(i + 1);

            prev.right = next;
            prev.left = null;
            next.left = null;
       } 

       return list.get(0);
    }
}