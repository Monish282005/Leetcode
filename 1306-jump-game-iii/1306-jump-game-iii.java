class Solution {
    public boolean dfs(int[] arr, int pos, boolean[] visited) {
        // Out of bounds
        if (pos < 0 || pos >= arr.length)
            return false;

        // Found the target
        if (arr[pos] == 0)
            return true;

        // Already visited this position — skip to break the cycle
        if (visited[pos])
            return false;

        visited[pos] = true; // Mark before recursing

        return dfs(arr, pos + arr[pos], visited) || 
               dfs(arr, pos - arr[pos], visited);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
}