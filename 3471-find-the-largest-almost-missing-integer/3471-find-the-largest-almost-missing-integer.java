class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> lastCount = new HashMap<>();

        int ans = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 0; i <= nums.length - k; i++) {

            for (int j = i; j < i + k; j++) {

                if (mp.containsKey(nums[j]) && lastCount.get(nums[j]) != count) {
                    mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                } else if(!mp.containsKey(nums[j])){
                    mp.put(nums[j], 1);
                }
                    lastCount.put(nums[j], count);
            }

            count++;
        }

        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            if (it.getValue() == 1) {
                ans = Math.max(ans, it.getKey());
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}