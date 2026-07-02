class Pair {
    int i;
    int j;
    int health;

    public Pair(int i, int j, int health) {
        this.i = i;
        this.j = j;
        this.health = health;
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.health - a.health);

        int[][] dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }

        int startDis = grid.get(0).get(0);
        dis[0][0] = startDis == 0 ? health : health - 1;
        pq.offer(new Pair(0, 0, dis[0][0]));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.i;
            int j = p.j;
            int h = p.health;

            if (i == m - 1 && j == n - 1 && h > 0) {
                return true;
            }

            if (h < dis[i][j])
                continue;

            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

            for (int[] it : dir) {
                int x = it[0] + i;
                int y = it[1] + j;

                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if (grid.get(x).get(y) == 1 && h - 1 > 0 && dis[x][y] < h - 1) {
                        dis[x][y] = h - 1;
                        pq.offer(new Pair(x, y, h - 1));
                    } else if (dis[x][y] < h && grid.get(x).get(y) == 0) {
                        dis[x][y] = h;
                        pq.offer(new Pair(x, y, h));
                    }
                }
            }
        }
        return false;
    }
}