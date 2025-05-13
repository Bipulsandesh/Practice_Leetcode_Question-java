class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000007;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        while(t > 0) {
            int z = freq[25];
            for(int i=25; i>1; i--) {
                freq[i] = freq[i-1];
            }
            freq[1] = (z + freq[0]) % MOD;
            freq[0] = z;
            t--;
        }
        int ans = 0;
        for(int count : freq) {
            ans = (ans + count) % MOD;
        }
        return ans;
    }
}