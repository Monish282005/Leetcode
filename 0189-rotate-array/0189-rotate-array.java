class Solution {
    public void rotate(int[] nums, int k) {
        int n =nums.length;
        int res[] = new int[n];

        int j = 0;

        for(int i = n - k % n; i < n; i++)
            res[j++] = nums[i];

        for(int i = 0; i < n -k % n; i++)
            res[j++] = nums[i];

        for(int i = 0; i < n; i++)
            nums[i] = res[i];
    }
}