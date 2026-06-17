class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int xor = 0;

        for(int i: nums)
            sum ^= i;
        
        for(int i = 0; i <= nums.length; i++)
            xor ^= i;

        return xor ^ sum;
    }
}