class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int i = cost.length - 1;

        int res = 0;
        int count = 0;

        while (i >= 0) {
            if (count < 2) {
                res += cost[i];
                count++;
            } else
                count = 0;
                
            i--;
        }

        return res;
    }
}