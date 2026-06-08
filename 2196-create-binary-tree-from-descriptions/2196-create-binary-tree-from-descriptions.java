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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> allNodes = new HashMap<>();
        Map<Integer, Integer> childs = new HashMap<>();

        for(int[] it: descriptions){
            TreeNode parent = null;
            TreeNode child = null;

            if(allNodes.containsKey(it[0])){
                parent = allNodes.get(it[0]);
            }else{
                parent = new TreeNode(it[0]);
                allNodes.put(it[0], parent);
            }

            if(allNodes.containsKey(it[1])){
                child = allNodes.get(it[1]);
            }else{
                child = new TreeNode(it[1]);
                allNodes.put(it[1], child);
            }

            if(it[2] == 1){
                parent.left = child;
            }else parent.right = child;

            childs.put(it[1], childs.getOrDefault(it[1], 0) + 1);
        }

        for(int[] it: descriptions){
            if(!childs.containsKey(it[0]))
                return allNodes.get(it[0]);
        }

        return null;
    }
}