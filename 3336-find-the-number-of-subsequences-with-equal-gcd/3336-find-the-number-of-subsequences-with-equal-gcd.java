class Solution {
    private static final int MOD = 1000000007;
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    public int subsequencePairCount(int[] nums) {
        int maxVal = 0;
        for(int num : nums) maxVal = Math.max(maxVal, num);

        int dp[][] = new int[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;

        for(int num : nums) {
            int ndp[][] = new int[maxVal + 1][maxVal + 1];
            for(int j = 0; j <= maxVal; j++) {
                int divisor1 = gcd(j, num);
                for(int k = 0; k <= maxVal; k++) {
                    int val = dp[j][k];
                    if(val == 0) continue;
                    int divisor2 = gcd(k, num);
                    ndp[j][k] = (ndp[j][k] + val) % MOD;
                    ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;
                    ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
                }
            }
            dp = ndp;
        }
        int result = 0;
        for(int j = 1; j <= maxVal; j++) result = (result + dp[j][j]) % MOD;
        return result;
    }
}