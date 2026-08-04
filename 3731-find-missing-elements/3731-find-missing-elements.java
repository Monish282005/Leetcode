class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
            mp.put(i, 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!mp.containsKey(i)) {
                res.add(i);
            }
        }
        return res;
    }
}