
class Solution {
    int max = 0, n = 0;
    Map<Integer, Integer> fre = new HashMap<>();

    public int subTree(TreeNode root) {
        if (root == null)
            return 0;

        int left = subTree(root.left);
        int right = subTree(root.right);

        int sum = left + right + root.val;

        fre.put(sum, fre.getOrDefault(sum, 0) + 1);

        max = Math.max(max, fre.get(sum));

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        subTree(root);
        int n = 0;

        for(int val: fre.values()){
            if(val == max)
                n++;
        }

        int[] arr = new int[n];
        int i = 0;
        for (Map.Entry<Integer, Integer> it : fre.entrySet()) {
            if (it.getValue() == max) {
                arr[i++] = it.getKey();
            }
        }

        return arr;
    }
}