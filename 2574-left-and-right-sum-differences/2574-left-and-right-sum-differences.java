class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 1; i < n; i++)
            left[i] = left[i - 1] + nums[i - 1];

       for(int i = 1; i < n; i++){
        right[n - i - 1] = right[n - i] + nums[n - i];
       }

        int res[] = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = Math.abs(left[i] - right[i]);
        }

        return res;
    }
}