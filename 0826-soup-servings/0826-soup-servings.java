class Solution {
    private double[][] dp;
    private double dfs(int a, int b){
        if (a <= 0 && b > 0){
            return 1.0;
        }
        if (a <= 0 && b <= 0){
            return 0.5;
        }
        if (a > 0 && b <= 0){
            return 0.0;
        }
        if (dp[a][b] != -1.0){
            return dp[a][b];
        }
        double res = 0.25 * (
            dfs(a - 4, b) + 
            dfs(a - 3, b - 1) + 
            dfs(a - 2, b - 2) + 
            dfs(a - 1, b - 3)
        );
        return dp[a][b] = res;
    };

    public double soupServings(int n) {
        if (n > 5000)
            return 1.0;
        int N = (int)Math.ceil(n / 25.0);
        int M = Math.max(201, N + 1);
        dp = new double[M][M];
        for (int i = 0; i < M; i++){
            Arrays.fill(dp[i], -1.0);
        }
        return dfs(N, N);
    }
}