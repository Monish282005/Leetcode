class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                boolean isValid = true;

                if (mat[i][j] == 1) {
                    int x = i, y = j;

                    while (x >= 0) {
                        if (mat[x][y] == 1 && x != i) {
                            isValid = false;
                            break;
                        }
                        x--;
                    }
                    x = i;
                    while (x < m) {
                        if (mat[x][y] == 1 && x != i) {
                            isValid = false;
                            break;
                        }
                        x++;
                    }
                    x = i;
                    while (y < n) {
                        if (mat[x][y] == 1 && y != j) {
                            isValid = false;
                            break;
                        }
                        y++;
                    }
                    y = j;

                    while (y >= 0) {
                        if (mat[x][y] == 1 && y != j) {
                            isValid = false;
                            break;
                        }
                        y--;
                    }

                if (isValid)
                    count++;
                }
            }
        }
        return count;
    }
}