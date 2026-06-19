class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int prefix[] = new int[n];
        Arrays.fill(prefix, 1);

        while(k-- > 0){
            for(int i = 1; i < n; i++){
                prefix[i] = (prefix[i] + prefix[i - 1]) % 1000000007;
            }
        }

        return  prefix[n - 1];
    }
}