class Solution {
    public int gcd(int odd, int even) {
        if (odd == 0) {
            return even;
        }

        return gcd(even % odd, odd);
    }

    public int gcdOfOddEvenSums(int n) {
        int odd = 1;
        int even = 2;

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= n; i++) {

            oddSum += odd;
            evenSum += even;
            odd += 2;
            even += 2;
        }

        if (oddSum > evenSum)
            return gcd(evenSum, oddSum);
        else
            return gcd(oddSum, evenSum);
    }
}