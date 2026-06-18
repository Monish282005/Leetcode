class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        long maxScore = 0;
        int score = 0;
        for (int i : nums){
                maxScore += i;
                if(maxScore > 0)
                    score++;
        }
        return score;

    }
}