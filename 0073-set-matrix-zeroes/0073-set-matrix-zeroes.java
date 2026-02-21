class Solution {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (Pair it : list) {
            int x = it.x, y = it.y;

            while (x >= 0)
                matrix[x--][y] = 0;
            x = it.x;

            while (x < matrix.length)
                matrix[x++][y] = 0;
            x = it.x;

            while (y < matrix[0].length)
                matrix[x][y++] = 0;
            y = it.y;

            while (y >= 0)
                matrix[x][y--] = 0;
            
        }
    }
}