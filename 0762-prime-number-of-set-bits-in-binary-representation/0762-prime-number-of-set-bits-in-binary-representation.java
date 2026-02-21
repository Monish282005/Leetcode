class Solution {
    public boolean isValid(int i) {
        int ones = Integer.bitCount(i);
        
        if (ones <= 1)
            return false;

        for (int j = 2; j * j <= ones; j++) {
            if (ones % j == 0)
                return false;
        }

        return true;

    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (isValid(i))
                count++;
        }
        return count;
    }
}