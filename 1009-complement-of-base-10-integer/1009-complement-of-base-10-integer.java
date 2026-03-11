class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int sum = 0;
        long pow = 1;
        while (n > 0) {
            int mod = n % 2;
            n /= 2;
            mod = (mod == 0 ? 1 : 0);
            if (mod == 1)
                sum += pow;
            pow = pow * 2;
        }
        return sum;
    }
}