class Solution {
    public long countCommas(long n) {
       long ans = 0;

       if(n >= 1000000000000000L)
       ans += n - 999999999999999L;
       if(n >= 1000000000000L){
       ans += n - 999999999999L;
       }
       if(n >= 1000000000L)
       ans += n - 999999999L;
       if(n >= 1000000)
       ans += n - 999999;
       if(n >= 1000)
       ans += n - 999;
       else
       return 0;
       


       return ans; 
    }
}