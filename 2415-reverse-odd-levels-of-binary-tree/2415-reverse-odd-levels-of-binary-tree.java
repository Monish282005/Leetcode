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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean level = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();
                while(size-- > 0){
                    TreeNode node = q.poll();
                    list.add(node);
                    arr.add(node.val);
                    if(node.left != null)
                        q.offer(node.left);
                    if(node.right != null)
                        q.offer(node.right);
                }
                if(!level){
                    Collections.reverse(arr);
                    for(int i = 0; i < list.size(); i++){
                        TreeNode temp = list.get(i);
                        temp.val = arr.get(i);
                    }
                }
                level = !level;
        }
        return root;
    }
}