class TrieNode {
    TrieNode children[];
    boolean isLast;

    public TrieNode() {
        children = new TrieNode[26];
        isLast = false;
    }
}

class Solution {
    public void dfs(char[][] board, int i, int j, List<String> res, StringBuilder sb, TrieNode root) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
        return;

        if(board[i][j] == '#' || root.children[board[i][j] - 'a'] == null)
            return;

        char temp = board[i][j];
        sb.append(board[i][j]);
        root = root.children[board[i][j] - 'a'];

        if (root.isLast) {
            res.add(sb.toString());
            root.isLast = false;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, res, sb, root);
        dfs(board, i - 1, j, res, sb, root);
        dfs(board, i, j + 1, res, sb, root);
        dfs(board, i, j - 1, res, sb, root);

        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (String s : words) {
            cur = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';

                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.isLast = true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cur = root;
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, res, new StringBuilder(), cur);
                }
            }
        }
        return res;

    }
}