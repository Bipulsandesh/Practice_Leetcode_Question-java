class Solution {
    long mod = (long)1e9+7;
    public int[] pathsWithMaxScore(List<String> b) {
        int m = b.size();
        int n = b.get(0).length();

        long[][] dp0 = new long[m][n]; // max sum
        long[][] dp1 = new long[m][n]; // count

        // base case : 

        // 0 0 
        dp0[0][0] = 0;
        dp1[0][0] = 1L; 

        for(int i = 1;i < n;i++){
            if(b.get(0).charAt(i) == 'X') break;
            dp1[0][i] = 1L;

            int num = b.get(0).charAt(i) - '0';
            dp0[0][i] = dp0[0][i-1] + num;
        }

        for(int j = 1;j < m;j++){
            if(b.get(j).charAt(0) == 'X') break;

            int num = b.get(j).charAt(0) - '0';

            dp0[j][0] = dp0[j-1][0] + num;
            dp1[j][0] = 1L;
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){

                // Transitions
                // three transistions

                if(b.get(i).charAt(j) == 'X') continue;

                long max = 0;
                // long cnt = 0;

                int num = b.get(i).charAt(j) - '0';
                if(i == m-1 && j == n-1){
                    num = 0;
                }

                if(dp1[i-1][j] > 0)
                    max = Math.max(max, dp0[i-1][j]);

                if(dp1[i][j-1] > 0)
                    max = Math.max(max, dp0[i][j-1]);

                if(dp1[i-1][j-1] > 0)
                    max = Math.max(max, dp0[i-1][j-1]);

                if(b.get(i-1).charAt(j) != 'X'){
                    if(max == dp0[i-1][j]){
                        dp0[i][j] = max+num;
                        dp1[i][j] = (dp1[i][j]%mod + dp1[i-1][j]%mod)%mod;
                    }
                }
                if(b.get(i).charAt(j-1) != 'X'){
                    if(max == dp0[i][j-1]){
                        dp0[i][j] = max+num;
                        dp1[i][j] = (dp1[i][j]%mod + dp1[i][j-1]%mod)%mod;
                    }
                }

                if(b.get(i-1).charAt(j-1) != 'X'){
                    if(max == dp0[i-1][j-1]){
                        dp0[i][j] = max+num;
                        dp1[i][j] = (dp1[i][j]%mod + dp1[i-1][j-1]%mod)%mod;
                    }
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = (int)dp0[m-1][n-1];
        ans[1] = (int)(dp1[m-1][n-1]%mod);

        return ans;
    }
}