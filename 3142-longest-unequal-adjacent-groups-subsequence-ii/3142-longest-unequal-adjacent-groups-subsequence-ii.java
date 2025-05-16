class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1, endIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() == words[j].length()
                        && groups[i] != groups[j]
                        && hammingDistance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }
        List<String> result = new ArrayList<>();
        int index = endIndex;
        while (index != -1) {
            result.add(words[index]);
            index = prev[index];
        }

        Collections.reverse(result);
        return result;
    }

    private int hammingDistance(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }
}