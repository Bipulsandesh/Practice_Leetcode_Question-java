class Solution {
    public long getDescentPeriods(int[] prices) {
        long c=1;
        long ans =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-1==prices[i]){
                c++;
            }
            else{
                ans += (c*(c+1))/2;
                c=1;
            }
        }
        ans += (c * (c + 1)) / 2;
        return ans;
    }
}