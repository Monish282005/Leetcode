class Solution {
    public boolean isValid(int i, int prime[]) {
        int ones = 0;
        while (i > 0) {
            if (i % 2 == 1)
                ones++;
            i /= 2;
        }

        if (prime[ones] == 0)
            return true;
        else
            return false;

    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int[] prime = new int[right + 1];
        prime[1] = 1;
        for (int i = 2; i * i <= right; i++) {
            if (prime[i] != 1) {
                for (int j = i * i; j <= right; j += i) {
                    prime[j] = 1;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (isValid(i, prime))
                count++;
        }
        return count;
    }
}