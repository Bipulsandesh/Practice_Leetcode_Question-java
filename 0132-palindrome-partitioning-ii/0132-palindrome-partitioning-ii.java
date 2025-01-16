class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCount(s, 0, dp) - 1;
    }

    private int minCount(String s, int start, int[] dp) {
        if (start == s.length()) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }

        int minCuts = Integer.MAX_VALUE;
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                int cuts = 1 + minCount(s, end + 1, dp);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        dp[start] = minCuts;
        return minCuts;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}