class NumArray {
    int tree[];
    int n;
    int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n * 4];
        build(nums, 0, 0, nums.length - 1);
    }

    public void build(int arr[], int node, int low, int high) {
        if (low == high) {
            tree[node] = nums[low];
            return;
        }

        int mid = (low + high) / 2;
        build(arr, (2 * node) + 1, low, mid);
        build(arr, (2 * node) + 2, mid + 1, high);

        tree[node] = tree[(node * 2) + 1] + tree[(node * 2) + 2];
    }

    public void updateTree(int idx, int val, int[] tree, int node, int low, int high) {
        if (low == high) {
            tree[node] = val;
            return;
        }

        int mid = (low + high) / 2;

        if (idx <= mid) {
            updateTree(idx, val, tree, (node * 2) + 1, low, mid);
        } else {
            updateTree(idx, val, tree, (node * 2) + 2, mid + 1, high);
        }

        tree[node] = tree[(node * 2) + 1] + tree[(node * 2) + 2];
    }

    public void update(int index, int val) {
        updateTree(index, val, tree, 0, 0, n - 1);
    }

    public int Query(int l, int r, int node, int low, int high){
        if(r < low || l > high)
            return 0;

        if(l <= low && high <= r)
            return tree[node];
        
        
        int mid = (low + high)/2;

        int left = Query(l, r, (2 * node) + 1, low, mid);
        int right = Query(l, r, (2 * node) + 2, mid + 1, high);

        return left + right;

    }
    public int sumRange(int left, int right) {
        return Query(left, right, 0, 0, n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */