class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, right = 0, up = 0, down = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U')
                up++;
            else if (c == 'D')
                down++;
            else if (c == 'L')
                left++;
            else
                right++;
        }

        return left == right && down == up;
    }
}