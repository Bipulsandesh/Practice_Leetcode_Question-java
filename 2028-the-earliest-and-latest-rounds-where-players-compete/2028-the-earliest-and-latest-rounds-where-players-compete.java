class Solution {
    private int[][][] F = new int[30][30][30]; // Earliest round memo
    private int[][][] G = new int[30][30][30]; // Latest round memo

    private int[] dp(int n, int f, int s) {
        // Return memoized result if available
        if (F[n][f][s] != 0) {
            return new int[] { F[n][f][s], G[n][f][s] };
        }
        
        // Base case: players face each other in current round
        if (f + s == n + 1) {
            return new int[] { 1, 1 };
        }
        
        // Handle symmetry: swap if players are in mirrored positions
        if (f + s > n + 1) {
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return new int[] { F[n][f][s], G[n][f][s] };
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;
        int n_half = (n + 1) / 2; // Next round player count
        
        if (s <= n_half) {
            // Both players in left half
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            // Players in different halves
            int s_prime = n + 1 - s;
            int mid = (n - 2 * s_prime + 1) / 2;
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s_prime - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + mid + 2);
                    earliest = Math.min(earliest, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        // Memoize results
        F[n][f][s] = earliest + 1;
        G[n][f][s] = latest + 1;
        return new int[] { F[n][f][s], G[n][f][s] };
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // Ensure firstPlayer < secondPlayer
        if (firstPlayer > secondPlayer) {
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }

        int[] res = dp(n, firstPlayer, secondPlayer);
        return new int[] { res[0], res[1] };
    }
}