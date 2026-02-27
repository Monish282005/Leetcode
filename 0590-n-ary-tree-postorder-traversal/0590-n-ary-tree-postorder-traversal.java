class Solution {
    public void post(List<Integer> res, Node root) {
        if (root == null)
            return;
        for (Node node : root.children) {
            post(res, node);
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        post(res, root);
        return res;
    }
}