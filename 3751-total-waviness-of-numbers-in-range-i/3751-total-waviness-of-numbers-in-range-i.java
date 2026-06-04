class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum = 0;

        while (num1 <= num2) {
            if (num1 > 100) {
                String s = Integer.toString(num1);

                for (int i = 0; i < s.length(); i++) {
                    if (i > 0 && i < s.length() - 1) {
                        int cur = s.charAt(i);
                        int prev = s.charAt(i - 1);
                        int next = s.charAt(i + 1);

                        if (prev < cur && cur > next || prev > cur && cur < next)
                            sum++;

                    }
                }
            }
            num1++;
        }

        return sum;
    }
}