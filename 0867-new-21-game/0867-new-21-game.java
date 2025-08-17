class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp=new double[n+1];
        dp[0]=1;
        double probability=k>0?1:0;
        for(int i=1;i<=n;i++){
            dp[i]=probability/maxPts;
            if(i<k){
                probability+=dp[i];
            }
            if(i-maxPts>=0 && i-maxPts<k){
                probability-=dp[i-maxPts];
            }
        }
        probability=0;
        for(int i=k;i<=n;i++){
            probability+=dp[i];
        }
        return probability;
    }
}