class Solution {
    public int numberOfWays(int n, int x) { 
        int MOD = (int) (1e9 + 7); 
        int[] dp = new int[n + 1]; 
        dp[0] = 1; 

        int limit = (int) Math.ceil(Math.pow(n, 1.0 / x)); // Find the biggest number we need to raise to the power of x 
                                                        // If x = 2, this is like finding the square root of n
                                                        // Math.ceil() is like rounding up (we use it to correct some math)

        for (int i = 1; i <= limit; i++) { // Looping through all the possible numbers to raise to the power of x (from 1 to our limit)
            long power = (long) Math.pow(i, x); // Calculating i to the power of x (like 2^2, 3^2, or 2^3, 3^3)

            for (int j = n; j >= power; j--) { // Looping through possible sums (from n down to power)
                dp[j] = (int) ((dp[j] + dp[j - (int) power]) % MOD); // The magic happens here!
                                                                       // dp[j] = existing ways to make 'j' + new ways to make 'j' using i^x
                                                                       // The % MOD is for avoiding overflow

            }
        }

        return dp[n]; // Return the total number of ways to make 'n'
    }
}