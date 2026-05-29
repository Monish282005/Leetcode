class Solution {
    public int digitSum(int n) {
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }

        return sum;
    }

    public int minElement(int[] nums) {

        int minSum = Integer.MAX_VALUE;

        for (int i : nums) {
            int sum = digitSum(i);

            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }
}