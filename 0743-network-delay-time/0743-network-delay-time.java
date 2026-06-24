class Pair{
    int node;
    int weight;
    public Pair(int weight, int node){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: times){
            int u = it[0];
            int v = it[1];
            int w = it[2];

            List<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(w);
            adj.get(u).add(temp);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.offer(new Pair(0, k));
        dis[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int w = p.weight;

            for(List<Integer> nei: adj.get(u)){
                int neiNode = nei.get(0);
                int neiWei = nei.get(1);

                if(dis[neiNode] > w + neiWei){
                    dis[neiNode] = w + neiWei;
                    pq.offer(new Pair(dis[neiNode], neiNode));
                }
            }
        }

        int maxTime = 0;

        for(int i = 1; i <= n; i++){
            maxTime = Math.max(dis[i], maxTime);
        }

        return maxTime == Integer.MAX_VALUE? -1: maxTime;
    }
}