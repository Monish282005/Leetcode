class Solution {
    Set<List<Integer>> ans = new HashSet<>();

    public void find(int[] num, List<Integer> temp, int i) {
        if (i == num.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(num[i]);
        find(num, temp, i + 1);
        temp.remove(temp.size() - 1);
        find(num, temp, i + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        find(nums, new ArrayList<>(), 0);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> it : ans)
            res.add(it);
        return res;
    }
}