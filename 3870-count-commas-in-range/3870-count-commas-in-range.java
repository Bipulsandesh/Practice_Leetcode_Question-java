class Solution {
    public int countCommas(int n) {
        long num=1000;
        int ans=0;
        while(num<=n){
            ans+=(n-num+1);
            num=num*1000;
        }
        return ans;
    }
}