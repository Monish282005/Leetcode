class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int size1 = 1, size2 = 1;

        for (int i = 2; i < n; i++) {
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }

        // Copy arr1 and arr2 into original nums
        System.arraycopy(arr1, 0, nums, 0, size1);
        System.arraycopy(arr2, 0, nums, size1, size2);

        return nums;
    }
}