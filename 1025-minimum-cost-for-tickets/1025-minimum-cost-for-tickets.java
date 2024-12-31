class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp=new int[days.length][366];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return func(0,0,days,costs,dp);
    }
    public int func(int i,int upto,int[] days,int costs[],int[][] dp){
        if(i==days.length) return 0;

        if(days[i]<=upto) return 0+func(i+1,upto,days,costs,dp);

        if(dp[i][upto]!=-1) return dp[i][upto];

        int a=costs[0]+func(i+1,days[i],days,costs,dp);
        int b=costs[1]+func(i+1,days[i]+6,days,costs,dp);
        int c=costs[2]+func(i+1,days[i]+29,days,costs,dp);

        return dp[i][upto]=Math.min(a,Math.min(b,c));
    }
}