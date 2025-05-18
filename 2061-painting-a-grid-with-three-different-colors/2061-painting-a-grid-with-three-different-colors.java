class Solution {
    private static final int mod = 1_000_000_007;
    private List<Integer> State = new ArrayList<>();
    private List<List<Integer>> matrix = new ArrayList<>();
    private void DFS(int m, int pos, int prevColor, int mask){
        if (pos == m){
            State.add(mask);
            return;
        }
        for (int color = 0; color < 3; color++){
            if (color != prevColor){
                DFS(m, pos + 1, color, mask * 3 + color);
            }
        }
    }
    private boolean valid(int a, int b, int m){
        for (int i = 0; i < m; i++){
            if ((a % 3) == (b % 3))
                return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }
    
    public int colorTheGrid(int m, int n) {
        DFS(m, 0, -1, 0);
        int s = State.size();
        for (int i = 0; i < s; i++){
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < s; i++){
            int v1 = State.get(i);
            for (int j = 0; j < s; j++){
                int v2 = State.get(j);
                if (valid(v1, v2, m)){
                    matrix.get(i).add(j);
                }
            }
        }
        int[] dp = new int[s];
        Arrays.fill(dp, 1);
        for (int col = 1; col < n; col++){
            int[] new_dp = new int[s];
            for (int i = 0; i < s; i++){
                if (dp[i] != 0){
                    for (int j : matrix.get(i)){
                        new_dp[j] = (int) ((new_dp[j] + (long) dp[i]) % mod);
                    }
                }
            }
            dp = new_dp;
        }
        int res = 0; 
        for (int count : dp){
            res = (res + count) % mod;
        }
        return res;
    }
}