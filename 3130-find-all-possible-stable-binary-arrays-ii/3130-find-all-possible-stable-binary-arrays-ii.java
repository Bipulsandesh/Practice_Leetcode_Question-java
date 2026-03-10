class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1_000_000_007;
        int Z = zero, O = one, L = limit;

        int[][] dp0 = new int[Z+1][O+1];
        int[][] dp1 = new int[Z+1][O+1];
        int[][] pref0 = new int[Z+1][O+1];
        int[][] pref1 = new int[Z+1][O+1];

        for(int z=1; z<=Math.min(Z,L); z++) dp0[z][0]=1;
        for(int o=1; o<=Math.min(O,L); o++) dp1[0][o]=1;

        for(int z=0; z<=Z; z++){
            for(int o=0; o<=O; o++){

                if(z>0 && o>0){
                    int left = pref1[z-1][o];
                    int right = (z-L-1>=0)? pref1[z-L-1][o] : 0;
                    dp0[z][o]=(left-right+MOD)%MOD;

                    left = pref0[z][o-1];
                    right = (o-L-1>=0)? pref0[z][o-L-1] : 0;
                    dp1[z][o]=(left-right+MOD)%MOD;
                }

                pref1[z][o]=((z>0?pref1[z-1][o]:0)+dp1[z][o])%MOD;
                pref0[z][o]=((o>0?pref0[z][o-1]:0)+dp0[z][o])%MOD;
            }
        }

        return (dp0[Z][O]+dp1[Z][O])%MOD;
    }
}