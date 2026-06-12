class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[][] graph, int node, List<Integer> temp) {
        temp.add(node);
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int nei : graph[node]) {
            dfs(graph, nei, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<>());
        return res;
    }
}