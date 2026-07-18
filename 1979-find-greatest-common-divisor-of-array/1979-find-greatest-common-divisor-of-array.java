class Solution {
    public int gcd(int a, int b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return gcd(min, max);

    }
}