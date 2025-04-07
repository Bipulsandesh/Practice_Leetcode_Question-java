class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Calculate total sum of elements
        for(int i = 0; i < n; i++)
            sum += nums[i];

        // If sum is odd, we can't partition into equal subsets
        if(sum % 2 == 1) return false;

        int t = sum / 2;

        // Initialize memoization table
        dp = new Boolean[n][t + 1];

        // Start recursion from index 0 and target sum = t
        return sol(nums, 0, t);
    }

    private boolean sol(int[] nums, int idx, int t) {
        // If target becomes negative, not a valid path
        if(t < 0) return false;

        // If target is 0, we've found a valid subset
        if(t == 0) return true;

        // If we've reached end of array without matching target
        if(idx == nums.length) return false;

        // If already computed, return stored result
        if(dp[idx][t] != null) return dp[idx][t];

        // Include current element in subset
        if(sol(nums, idx + 1, t - nums[idx]))
            return dp[idx][t] = true;

        // Exclude current element from subset
        return dp[idx][t] = sol(nums, idx + 1, t);
    }
}

