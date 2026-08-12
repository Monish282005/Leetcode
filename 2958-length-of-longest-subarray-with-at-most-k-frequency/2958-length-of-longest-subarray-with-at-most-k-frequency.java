class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

                while (mp.get(nums[right]) > k) {
                    mp.put(nums[left], mp.get(nums[left]) - 1);

                    if (mp.get(nums[left]) == 0) {
                        mp.remove(nums[left]);
                    }
                    left++;
                }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}