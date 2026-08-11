class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int pos = nums.length/2;

        int moves = 0;
        int mid = nums[pos];
        for(int i: nums){
            moves += Math.abs(i - mid);
        }

        return moves;
    }
}