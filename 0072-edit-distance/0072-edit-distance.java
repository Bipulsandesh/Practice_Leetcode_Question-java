class Solution {
    static int helper(String s, String t, Integer dp[][]) {
        if(dp[s.length()][t.length()] != null) {
            return dp[s.length()][t.length()];
        }
        while(s.length() > 0 && t.length() > 0) {
            if(s.charAt(0) != t.charAt(0)) {
                break;
            }
            s = s.substring(1);
            t = t.substring(1);
        }
        if(s.length() == 0) {
            return t.length();
        }
        if(t.length() == 0) {
            return s.length();
        }
        return dp[s.length()][t.length()] = 1 + Math.min(Math.min(helper(s, t.substring(1), dp), helper(s.substring(1), t, dp)), helper(s.substring(1), t.substring(1), dp));
    }
    public int minDistance(String word1, String word2) {
        // if(wo)
        Integer dp[][] = new Integer[word1.length() + 1][word2.length() + 1];
        return helper(word1, word2, dp);
    }
}