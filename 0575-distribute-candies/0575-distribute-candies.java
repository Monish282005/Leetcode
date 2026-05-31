class Solution {
    public int distributeCandies(int[] candyType) {
        int res = 0;
        int m = candyType.length/2;
        Map<Integer, Integer> mp = new HashMap<>();


        for(int i: candyType){
            if(!mp.containsKey(i)){
                if(res < m){
                    res++;
                    mp.put(i, 1);
                }else break;
            }
        }

        return res;
    }
}