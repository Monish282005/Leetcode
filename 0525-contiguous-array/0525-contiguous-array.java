class Solution {
    public int findMaxLength(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int maxLen = 0;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];

            if(!mp.containsKey(curSum)){
                mp.put(curSum, i);
            }else{
                maxLen = Math.max(maxLen, i - mp.get(curSum));
            }
        }

        return maxLen;
    }
}