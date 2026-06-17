class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == mid) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return left;
    }
}