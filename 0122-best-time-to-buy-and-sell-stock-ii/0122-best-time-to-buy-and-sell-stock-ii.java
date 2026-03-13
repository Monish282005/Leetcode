class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int stock = Integer.MAX_VALUE;
        int dif = 0;

        for (int i : prices) {
            if (i < stock && dif == 0) {
                stock = i;
            } else if (i - stock > dif) {
                dif = i - stock;
            } else {
                maxProfit += dif;
                dif = 0;
                stock = i;
            }
        }
        maxProfit += dif;
        return maxProfit;
    }
}