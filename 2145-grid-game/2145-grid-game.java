class Solution {
    public long gridGame(int[][] grid) {
        final int n = grid[0].length;
        long ans = Long.MAX_VALUE; // Initialize the result to a large value
        long sumRow0 = 0;          // Total sum of the top row
        long sumRow1 = 0;          // Accumulated sum of the bottom row

        // Compute the total sum of the top row
        for (int col = 0; col < n; col++) {
            sumRow0 += grid[0][col];
        }

        // Iterate through each column to calculate the minimum maximum score
        for (int col = 0; col < n; col++) {
            sumRow0 -= grid[0][col]; // Decrease top row sum for current column
            ans = Math.min(ans, Math.max(sumRow0, sumRow1)); // Update result
            sumRow1 += grid[1][col]; // Accumulate bottom row sum
        }

        return ans; // Return the minimum maximum score
    }
}