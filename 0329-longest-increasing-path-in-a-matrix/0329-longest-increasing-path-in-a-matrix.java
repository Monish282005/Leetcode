class Solution {
    int maxLen = 0;
    int[][] dp;
    public int find(int[][] arr, int i, int j, int len){
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ans = 1;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];

            if(x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && arr[i][j] > arr[x][y]){
                ans = Math.max(ans, 1 + find(arr, x, y, len + 1));
            }
        }

        return dp[i][j] = ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxLen = Math.max(maxLen, find(matrix, i, j, 1));
            }
        }

        return maxLen;
    }
}