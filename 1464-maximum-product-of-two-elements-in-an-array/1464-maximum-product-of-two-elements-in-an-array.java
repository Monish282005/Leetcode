class Solution {
    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second)
                second = i;
        }

        return (first - 1) * (second - 1);
    }
}