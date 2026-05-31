class Solution {
    public int distributeCandies(int[] candyType) {
        int m = candyType.length;
        Arrays.sort(candyType);
        int n = m/2;

        int res = 0;
        int prev = Integer.MAX_VALUE;
        for(int i: candyType){
            if(prev != i){
                if(res < n){
                    res++;
                    prev = i;
                }
            }
        }
        return res;
    }
}