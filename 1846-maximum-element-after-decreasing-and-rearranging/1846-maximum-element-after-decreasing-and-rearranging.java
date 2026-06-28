class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int k = 1;

            arr[0] = 1;
            for(int i = 1; i < n; i++){
                int abs = Math.abs(arr[i] - arr[i - 1]);

                if(abs > 1){
                    arr[i] = arr[i - 1] + 1;
                }
            }
        

        return arr[n - 1];
    }
}