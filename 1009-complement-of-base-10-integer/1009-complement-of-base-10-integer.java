class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int ans = 0;
        int bit = 1;

        while(n > 0){
            if((n & 1) == 0){
                ans |= bit;
            }

            bit <<= 1;
            n >>= 1;
        }

        return ans;
        
    }
}