class Solution {
    long sum = 0;
    long newVal = 0;

    public void digit(long n) {

        while (n != 0) {
            long rem = n % 10;

            if (rem != 0) {
                newVal = (newVal * 10) + rem;
                sum += rem;
            }
            n /= 10;
        }
    }

    public long sumAndMultiply(int n) {
        digit(n);
        long temp = newVal;
        newVal = 0;
        sum = 0;
        newVal = 0;
        digit(temp);

        return newVal * sum;
    }
}