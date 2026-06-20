class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                boolean down = i + 1 >= m? true: grid[i][j] == grid[i + 1][j];
                boolean right = j + 1 >= n? true: grid[i][j + 1] != grid[i][j];

                if(!(down && right)){
                    return false;
                }
            }

        }
            return true;
    }
}