class Solution {
    public int countPrimes(int n) {
        int prime[] = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j = j + i) {
                if (j % i == 0 && prime[j] != 1) {
                    prime[j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < prime.length - 1; i++)
            if (prime[i] == 0)
                count++;
        return count;
    }
}