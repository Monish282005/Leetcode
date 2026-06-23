public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();

    }
    public void dfs(TreeNode r,StringBuilder sb){
        if(r == null){
            sb.append("N,");
            return;
        }
        sb.append(r.val).append(",");
        dfs(r.left,sb);
        dfs(r.right,sb);
    }
    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] a = data.split(",");
        idx = 0;
        return defs(a);
    }
    
    public TreeNode defs(String[] data){
        if(data[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        root.left = defs(data);
        root.right = defs(data);
        return root;
    }
}