public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], (i >= 2 ? dp[i - 2] : 0) + nums[i]);
        }

        return dp[nums.length - 1];
    }
}