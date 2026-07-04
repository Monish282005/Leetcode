class Solution {
    int[] rank;
    int[] parent;

    public void union(int u, int v) {
        int ulpU = find(u);
        int ulpV = find(v);


        if (rank[ulpU] > rank[ulpV]) {
            parent[ulpV] = ulpU;
        } else if (rank[ulpU] < rank[ulpV]) {
            parent[ulpU] = ulpV;
        } else {
            parent[ulpU] = ulpV;
            rank[ulpV]++;
        }
    }

    public int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++)
            parent[i] = i;

        int minScore = Integer.MAX_VALUE;

        for (int[] it : roads) {
            int u = it[0];
            int v = it[1];

            union(u, v);
        }

        for(int[] it: roads){
            int u = it[0];
            int v = it[1];
            int w = it[2];

             if(find(u) == find(n) && find(v) == find(n)){
                minScore = Math.min(minScore, w);
             }   

        }

        return minScore;
    }
}