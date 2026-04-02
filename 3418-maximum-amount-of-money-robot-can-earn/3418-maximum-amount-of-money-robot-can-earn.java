class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        // 3 states for neutralisations used: 0, 1, or 2
        int[][][] dp = new int[m][n][3];

        // Initialise all states to "impossible" (very small number)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        // Starting cell: if it's non‑negative, we just take it with 0 neutralisations.
        dp[0][0][0] = coins[0][0];
        // If the start cell is a robber, we can neutralise it right away (used=1)
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;   // neutralise -> coins become 0, used 1
        }

        // Fill the DP table row by row, column by column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the starting cell — already initialised
                if (i == 0 && j == 0) continue;

                // For each possible number of neutralisations used so far (0,1,2)
                for (int used = 0; used < 3; used++) {
                    int best = Integer.MIN_VALUE;

                    // ---- Come from the TOP cell (i-1, j) ----
                    if (i > 0) {
                        // Option 1: Do NOT neutralise current cell
                        if (dp[i-1][j][used] != Integer.MIN_VALUE) {
                            int val = dp[i-1][j][used] + coins[i][j];
                            best = Math.max(best, val);
                        }
                        // Option 2: Neutralise current cell (only if we have a neutralisation left
                        //           and the current cell is actually a robber)
                        if (used > 0 && coins[i][j] < 0) {
                            if (dp[i-1][j][used-1] != Integer.MIN_VALUE) {
                                int val = dp[i-1][j][used-1] + 0; // neutralise -> add 0
                                best = Math.max(best, val);
                            }
                        }
                    }

                    // ---- Come from the LEFT cell (i, j-1) ----
                    if (j > 0) {
                        // Option 1: Do NOT neutralise
                        if (dp[i][j-1][used] != Integer.MIN_VALUE) {
                            int val = dp[i][j-1][used] + coins[i][j];
                            best = Math.max(best, val);
                        }
                        // Option 2: Neutralise (if possible)
                        if (used > 0 && coins[i][j] < 0) {
                            if (dp[i][j-1][used-1] != Integer.MIN_VALUE) {
                                int val = dp[i][j-1][used-1] + 0;
                                best = Math.max(best, val);
                            }
                        }
                    }

                    // Store the best value for this cell and this number of neutralisations
                    dp[i][j][used] = best;
                }
            }
        }

        // The answer is the maximum over all possible numbers of neutralisations used
        // at the bottom‑right corner.
        return Math.max(dp[m-1][n-1][0],
                       Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}