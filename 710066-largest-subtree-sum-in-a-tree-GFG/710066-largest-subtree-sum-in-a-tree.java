/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int max = Integer.MIN_VALUE;
    
    public int subTree(Node root){
        if(root == null)
            return 0;
        
        int left = subTree(root.left);
        int right = subTree(root.right);
        
        int sum = left + right + root.data;
        
        max = Math.max(sum, max);
        
        return sum;
    }
    public int findLargestSubtreeSum(Node root) {
        // code here
        subTree(root);
        return max;
    }
}
