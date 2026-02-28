class Solution {
    public int concatenatedBinary(int n) {
        int MOD = (int)1e9 + 7;
        long ans = 0;
        int bitLen = 0;

        for(int i = 1; i <= n; i++){
            if((i & (i-1)) == 0) bitLen++;

            ans = ((ans << bitLen)+i) % MOD;
        }
        
        return (int)ans;
    }
}