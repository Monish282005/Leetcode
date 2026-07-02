import java.util.*;

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

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> b.health - a.health);

        int[][] dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        dis[0][0] = startHealth;

        pq.offer(new Pair(0, 0, startHealth));

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int i = p.i;
            int j = p.j;
            int h = p.health;

            // Ignore outdated states
            if (h < dis[i][j])
                continue;

            if (i == m - 1 && j == n - 1)
                return true;

            for (int[] d : dir) {

                int x = i + d[0];
                int y = j + d[1];

                if (x < 0 || y < 0 || x >= m || y >= n)
                    continue;

                if (grid.get(x).get(y) == 1) {

                    if (h - 1 > 0 && dis[x][y] < h - 1) {

                        dis[x][y] = h - 1;
                        pq.offer(new Pair(x, y, h - 1));
                    }

                } else {

                    if (dis[x][y] < h) {

                        dis[x][y] = h;
                        pq.offer(new Pair(x, y, h));
                    }
                }
            }
        }

        return false;
    }
}