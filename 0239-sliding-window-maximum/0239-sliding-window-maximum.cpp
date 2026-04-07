class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        vector<int> res;
        priority_queue<int> pq;

        for (int i = 0; i < k; i++) {
            mp[nums[i]]++;
            pq.push(nums[i]);
        }

        res.push_back(pq.top());

        for (int i = k; i < nums.size(); i++) {
            mp[nums[i]]++;
            mp[nums[i - k]]--;

            if (mp[nums[i - k]] == 0)
                mp.erase(nums[i - k]);

                while(pq.size() > 0 && mp.find(pq.top()) == mp.end())
                    pq.pop();

                pq.push(nums[i]);
                res.push_back(pq.top());
        }

        return res;
    }
};