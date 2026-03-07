class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0)
            return new int[n];

        int res[] = new int[n];
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int j = i + 1, m = 0, sum = 0;
                while (m < k) {
                    sum += code[j % n];
                    m++;
                    j++;
                }
                res[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int j = i - 1, sum = 0, m = 0;
                while (m < k * -1) {
                    sum += code[(j + n) % n];
                    j--;
                    m++;
                }
                res[i] = sum;
            }
        }
        return res;
    }
}