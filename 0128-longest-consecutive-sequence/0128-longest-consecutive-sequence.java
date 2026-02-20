class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int len = 1, maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            while(i < nums.length && nums[i] == nums[i - 1]) i++;
            if (i < nums.length && nums[i] == nums[i - 1] + 1)
                len++;
            else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);

        return maxLen;
    }
}