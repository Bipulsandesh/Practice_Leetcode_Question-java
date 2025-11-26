class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i ++) 
            for (int j = 0; j < m; j ++)
                for (int l = 0; l < k + 1; l ++)
                    dp[i][j][l] = -1;
        int ans = func(0,0,0,grid,dp,k);
        return ans;
    }
    int func(int i,int j, int s,int[][] g, int[][][] dp, int k) {
        int mod = 1000000007;
        int n = g.length;
        int m  = g[0].length;
        if (n- 1 == i && m - 1 == j) {
            s += g[i][j];
            s %= k;
            if (s == 0) return 1;
            return 0;
        }
        if (i >= n || j >= m) return 0;
        if (dp[i][j][s] != -1) return dp[i][j][s];
        int r = func(i,j + 1,(s + g[i][j]) % k,g,dp,k);
        int d = func(i + 1,j,(s + g[i][j]) % k,g,dp,k);
        dp[i][j][s] = (r + d) % mod;
        return dp[i][j][s];     
    }
}