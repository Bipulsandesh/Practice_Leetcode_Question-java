class Solution {
    public int numTrees(int n) {

        int dp[] = new int[n + 1];

        if(n < 2)
            return 1;

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            int ans = 0, f = 0, s = i - 1;

            for(int j = 1 ; j <= i ; j++){
                ans = ans + (dp[f] * dp[s]);
                f++;
                s--;
            }

            dp[i] = ans;
        }

        return dp[n];
        
    }
}