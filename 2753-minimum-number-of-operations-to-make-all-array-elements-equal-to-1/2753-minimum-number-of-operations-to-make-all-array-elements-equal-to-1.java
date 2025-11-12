class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ones = 0, g = 0;
        for (int x : nums) {
            if (x == 1) ones++;
            g = gcd(g, x);
        }
        if (ones > 0) return n - ones;
        if (g > 1) return -1;

        int minLen = n;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i; j < n && cur > 1; j++) {
                cur = gcd(cur, nums[j]);
                if (cur == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}