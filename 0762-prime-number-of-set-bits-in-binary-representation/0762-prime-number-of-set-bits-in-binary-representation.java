class Solution {
    public boolean isValid(int i) {
        int ones = 0;
        while (i > 0) {
            if (i % 2 == 1)
                ones++;
            i /= 2;
        }

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