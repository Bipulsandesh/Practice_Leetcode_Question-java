class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        if (n == 2) {
            long ans = 0;
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long[] prefDown = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long[] prefUp = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
            }

            long totalUp = prefUp[m];

            for (int v = 1; v <= m; v++) {
                newUp[v] = prefDown[v - 1];

                newDown[v] =
                        (totalUp - prefUp[v] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}