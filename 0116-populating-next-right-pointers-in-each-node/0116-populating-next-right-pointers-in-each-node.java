
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
    
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node node = q.poll();
                if (!q.isEmpty() && size != 0)
                    node.next = q.peek();
                
                if (node != null && node.left != null)
                    q.offer(node.left);
                if (node != null && node.right != null)
                    q.offer(node.right);
            }
        }
        return root;
    }
}