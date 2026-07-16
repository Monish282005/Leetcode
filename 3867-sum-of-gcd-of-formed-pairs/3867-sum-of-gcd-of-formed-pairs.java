class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefix[i] = max > nums[i] ? gcd(max, nums[i]) : gcd(nums[i], max);
            // System.out.println(prefix[i]);
        }

        Arrays.sort(prefix);
        int i = 0, j = n - 1;
        long sum = 0;
        while (i < j) {
            sum += prefix[i] > prefix[j] ? gcd(prefix[i], prefix[j]) : gcd(prefix[j], prefix[i]);
            i++;
            j--;
        }
        return sum;
    }
}