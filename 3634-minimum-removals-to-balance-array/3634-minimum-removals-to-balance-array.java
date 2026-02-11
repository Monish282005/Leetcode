class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length == 1) return 0;

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int minLen = -1;

        while(i < j){
            int min = nums[i], max = nums[j];
            if(min * k >= max){
             minLen = Math.max(minLen, j - i + 1);
                i++;
            }
            else j--;
        }
       minLen = Math.max(minLen, j - i + 1);
        return nums.length - minLen;
    }
}