class Pair {
    int node;
    int price;
    int stops;

    public Pair(int node, int price, int stops) {
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] it: flights){
            int u = it[0];
            int v = it[1];
            int p = it[2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, p)));
        }

        int[][] dis = new int[n][k + 1];
        for(int[] it: dis){
            Arrays.fill(it, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.price - b.price);

        pq.offer(new Pair(src, 0, 0));
        dis[src][0] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int s = p.stops;
            int price = p.price;

            for(List<Integer> nei: adj.get(u)){
                int neiNode = nei.get(0);
                int neiPrice = nei.get(1);

                if(s <= k && dis[neiNode][s] > price + neiPrice){
                    dis[neiNode][s] = price + neiPrice;
                    pq.offer(new Pair(neiNode, price + neiPrice, s + 1));
                }
            }
        }
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i <= k; i++){
            minPrice = Math.min(minPrice, dis[dst][i]);
        }

        return minPrice == Integer.MAX_VALUE ? -1: minPrice;
    }
}