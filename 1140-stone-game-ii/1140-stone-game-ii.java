class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = piles[n - 1 - i];
        }
        int [][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return total(n-1,1,arr,dp);
    }
    private int total(int ind,int M,int[]arr,int[][]dp){
        if(ind < 0)return 0;
        if(dp[ind][M] != -1)return dp[ind][M];

       int take = 0;
       int best = 0;

       for(int x=1;x<=2*M && ind - x + 1 >= 0; x++){
        take += arr[ind-x+1];

        int opp = total(ind-x,Math.max(x,M),arr,dp);


        int total=0;
        for(int i=0;i<=ind;i++){
            total += arr[i];
        }
        int curr = (total-opp);

        best = Math.max(best,curr);
       }
       return dp[ind][M] = best;


    }
}