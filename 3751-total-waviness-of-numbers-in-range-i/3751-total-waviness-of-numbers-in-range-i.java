class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        
        // Reusable array to hold digits of the current number
        int[] digits = new int[6]; 

        while (num1 <= num2) {
            if (num1 > 100) {
                int temp = num1;
                int len = 0;

                // Extract digits into the array (stores them in reverse order)
                while (temp > 0) {
                    digits[len] = temp % 10;
                    temp /= 10;
                    len++;
                }

                // Check for wavy patterns using the array indexes
                for (int i = 1; i < len - 1; i++) {
                    int prev = digits[i - 1];
                    int cur = digits[i];
                    int next = digits[i + 1];

                    if ((prev < cur && cur > next) || (prev > cur && cur < next)) {
                        sum++;
                    }
                }
            }
            num1++;
        }

        return sum;
    }
}