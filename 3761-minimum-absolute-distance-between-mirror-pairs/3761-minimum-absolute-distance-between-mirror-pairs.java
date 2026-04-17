class Solution {
    public int reverse(int n) {
        boolean negative = n < 0;
        if (negative) n = -n;

        int ans = 0;
        while (n != 0) {
            ans = ans * 10 + (n % 10);
            n /= 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        int minAbs = Integer.MAX_VALUE;
        // key = reverse(nums[i]), value = most recent index i
        Map<Integer, Integer> mp = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            // Check if nums[j] matches reverse(nums[i]) stored earlier
            if (mp.containsKey(nums[j])) {
                minAbs = Math.min(minAbs, j - mp.get(nums[j]));
            }

            // Store reverse(nums[j]) so future j' can match against it
            mp.put(reverse(nums[j]), j);
        }

        return minAbs == Integer.MAX_VALUE ? -1 : minAbs;
    }
}