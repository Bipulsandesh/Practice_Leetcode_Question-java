class Solution {
    Integer[][] dp;
    public int solve(int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i == j){
            return nums[i];
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int takei = nums[i] + Math.min((solve(i+2,j,nums)),solve(i+1,j-1,nums));
        int takej = nums[j] + Math.min((solve(i+1,j-1,nums)),solve(i,j-2,nums));
        return dp[i][j] = Math.max(takei,takej);
    }
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        dp = new Integer[nums.length+1][nums.length+1];
        int player1 = solve(0,nums.length-1,nums);
        int player2 = sum - player1;
        if(player1>=player2){
            return true;
        }
        return false;
    }
}