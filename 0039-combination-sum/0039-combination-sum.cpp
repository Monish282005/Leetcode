class Solution {
public:
    void solve(int idx, vector<vector<int>>& ans, int sum, vector<int>& temp,
               int target, vector<int>& arr) {
        if (sum == target) {
            ans.push_back(temp);
            return;
        }

        if (idx >= arr.size() || sum > target) {
            return;
        }


        temp.push_back(arr[idx]);
        solve(idx, ans, sum + arr[idx], temp, target, arr);
        temp.pop_back();
        solve(idx + 1, ans, sum, temp, target, arr);

    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> temp;
        solve(0, ans, 0, temp, target, candidates);
        return ans;
    }
};