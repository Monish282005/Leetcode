class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] it : trust)
            adj.get(it[0]).add(it[1]);

        int judge = -1;
        for (int i = 1; i <= n; i++)
            if (adj.get(i).size() == 0)
                judge = i;

        if (judge == -1)
            return -1;

        int count = 0;

        for (int i = 1; i <= n; i++)
            for (int nei : adj.get(i)) {
                if (nei == judge)
                    count++;
            }

        if (count == n - 1)
            return judge;

        return -1;
    }
}