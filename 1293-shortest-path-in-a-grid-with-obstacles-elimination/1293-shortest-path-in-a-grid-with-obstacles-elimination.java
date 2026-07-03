class Pair {
    int i;
    int j;
    int k;
    int steps;

    public Pair(int i, int j, int k, int steps) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.steps = steps;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.steps - b.steps);

        int[][][] dis =new int[m][n][k + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dis[i][j], Integer.MAX_VALUE);
            }
        }

        boolean[][][] vis = new boolean[m][n][k + 1];

        pq.offer(new Pair(0, 0, k, 0));
        dis[0][0][0] = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.i;
            int j = p.j;
            int pass = p.k;
            int step = p.steps;

            
            for(int[] it: dir){
                int x = it[0] + i;
                int y = it[1] + j;

                if(x < 0 || y < 0 || x >= m || y >= n)
                    continue;
                
                if(grid[x][y] == 1 && pass - 1 >= 0){
                     if(dis[x][y][pass - 1] > step + 1){
                        dis[x][y][pass - 1] = step + 1;
                        pq.offer(new Pair(x, y, pass - 1, step + 1));
                     }   
                }else if(grid[x][y] == 0){
                    if(dis[x][y][pass] > step + 1){
                        dis[x][y][pass] = step + 1;
                        pq.offer(new Pair(x, y, pass, step + 1));
                    }
                }

            }
        }

        int minSteps = Integer.MAX_VALUE;

        for(int i = 0; i <= k; i++){
            minSteps = Math.min(minSteps, dis[m - 1][n - 1][i]);
        }

        return minSteps == Integer.MAX_VALUE? -1: minSteps;

    }
}