class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long next = 0, curr = 0; // Two variables to track DP state
        long[] dp = new long[n + 1]; // Temporary DP storage to handle lookahead

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;

            // Compute take (if within bounds)
            long take = points + (nextIndex < n ? dp[nextIndex] : 0);
            long skip = next; // Skip this question

            curr = Math.max(skip, take); // Update current max
            dp[i] = curr; // Store result for future calculations
            next = curr; // Move forward in DP
        }

        return curr;
    }
}



