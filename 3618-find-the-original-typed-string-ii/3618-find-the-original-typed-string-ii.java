class Solution {

    private static final int mod = 1000000007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();

        // ✅ Step 1: Consecutive same characters ko groups mein divide karo
        // Example: "aaabbcc" → groups = [3,2,2]
        List<Integer> groupSizes = new ArrayList<>();
        int currentCount = 1;

        for (int i = 1; i < n; ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                currentCount++;
            } else {
                groupSizes.add(currentCount);
                currentCount = 1;
            }
        }
        groupSizes.add(currentCount); // last group add karna mat bhoolna

        // ✅ Step 2: Total combinations calculate karo (without k constraint)
        // Har group se 1 se groupSize tak character le sakte ho
        long totalWays = 1;
        for (int size : groupSizes) {
            totalWays = (totalWays * size) % mod;
        }

        // ✅ Step 3: Agar groups k ya usse zyada hain, toh koi dikkat nahi
        // Seedha totalWays return kar do
        if (groupSizes.size() >= k) {
            return (int) totalWays;
        }

        // ✅ Step 4: DP lagayenge to count subsequences with < k groups
        // dp[j] → number of ways to form string using exactly (j+1) groups
        int[] dp = new int[k];
        int[] prefixSum = new int[k];

        dp[0] = 1;
        Arrays.fill(prefixSum, 1); // prefixSum[j] = dp[0] + dp[1] + ... + dp[j]

        // ✅ Step 5: Har group ke liye DP update karenge
        for (int i = 0; i < groupSizes.size(); ++i) {
            int groupSize = groupSizes.get(i);
            int[] newDp = new int[k];

            for (int j = 1; j < k; ++j) {
                // Prefix sum se fast calculate ho jaata hai
                newDp[j] = prefixSum[j - 1];

                // Agar j - groupSize - 1 >= 0 hai, toh wo invalid combos subtract karo
                if (j - groupSize - 1 >= 0) {
                    newDp[j] = (newDp[j] - prefixSum[j - groupSize - 1] + mod) % mod;
                }
            }

            // Naya prefix sum array banao next iteration ke liye
            int[] newPrefix = new int[k];
            newPrefix[0] = newDp[0];
            for (int j = 1; j < k; ++j) {
                newPrefix[j] = (newPrefix[j - 1] + newDp[j]) % mod;
            }

            dp = newDp;
            prefixSum = newPrefix;
        }

        // ✅ Step 6: Final answer = totalWays - invalidWays (jo < k groups se bane)
        return (int) ((totalWays - prefixSum[k - 1] + mod) % mod);
    }
}