class Solution {
    int edge;
    int nodes;

    public void dfs(List<List<Integer>> adj, boolean[] vis, int node){
        if(vis[node]){
            return;
        }

        vis[node] = true;
        nodes++;

        for(int nei: adj.get(node)){

                edge++;
                dfs(adj, vis, nei);
            
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                edge = nodes = 0;
                dfs(adj, vis, i);
                
                if(edge/2 == nodes * (nodes - 1)/2){
                    count++;
                }
            }
        }
        return count;   
    }
}