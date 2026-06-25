class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
     int count = 0;
     int n = nums.length;

     for(int i = 0; i < n; i++){
     Map<Integer, Integer> mp = new HashMap<>();
     for(int j = i; j < n; j++){
        if(nums[j] == target){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
        }
        if(mp.containsKey(target) && mp.get(target) > (j - i + 1) / 2){
            count++;
        }
     }
     }   

     return count;
    }
}