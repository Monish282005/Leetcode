class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, right = 0, up = 0, down = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                if (down != 0) {
                    down--;
                } else
                    up++;
            }

            else if (c == 'D') {
                if (up != 0) {
                    up--;
                } else
                    down++;
            }

            else if (c == 'L') {
                if (right != 0)
                    right--;
                else
                    left++;
            }

            else {
                if (left != 0)
                    left--;
                else
                    right++;
            }
        }

        return left == 0 && right == 0 && up == 0 && down == 0;
    }
}