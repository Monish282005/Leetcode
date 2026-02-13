class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void find(int k, int n, int sum, List<Integer> temp, int i) {
        if (sum == n && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(i > 9 || sum > n)
            return;
        
        temp.add(i);
        find(k, n, sum + i, temp, i + 1);
        temp.remove(temp.size() - 1);
        find(k ,n, sum, temp, i + 1);

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        find(k, n, 0, new ArrayList<>(), 1);
        return res;
    }
}