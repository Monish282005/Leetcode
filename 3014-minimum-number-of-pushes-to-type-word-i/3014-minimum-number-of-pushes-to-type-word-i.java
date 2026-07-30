class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int count = 0;

        int i = 1;

        while (n > 0) {
            int rem = n - 8;

            if (rem < 0) {
                count += (n * i);
                break;
            }

            n -= 8;
            count += (i * 8);
            i++;
        }

        return count;
    }
}