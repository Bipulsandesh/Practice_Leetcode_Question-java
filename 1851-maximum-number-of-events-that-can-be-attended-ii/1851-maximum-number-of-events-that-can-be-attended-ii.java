class Solution {
    int[][] dp;
    
    public int maxValue(int[][] events, int k) {
        // Sort events by start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        
        // Initialize DP table with -1 (uncomputed)
        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 0, -1, events, k);
    }
    
    private int dfs(int curIndex, int count, int prevEnd, int[][] events, int k) {
        // Base case: no more events or attended enough
        if (curIndex == events.length || count == k) {
            return 0;
        }
        
        // Skip if current event overlaps with previous
        if (prevEnd >= events[curIndex][0]) {
            return dfs(curIndex + 1, count, prevEnd, events, k);
        }
        
        // Return memoized result if available
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        
        // Choose max between skipping or attending current event
        int maxVal = Math.max(
            dfs(curIndex + 1, count, prevEnd, events, k), // Skip
            dfs(curIndex + 1, count + 1, events[curIndex][1], events, k) + events[curIndex][2] // Attend
        );
        
        // Memoize result
        dp[count][curIndex] = maxVal;
        return maxVal;
    }
}