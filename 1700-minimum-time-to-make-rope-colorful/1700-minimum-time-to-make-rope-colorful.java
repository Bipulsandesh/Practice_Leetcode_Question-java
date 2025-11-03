class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                dp[i] = dp[i - 1] + Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}