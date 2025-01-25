class Solution {
 
    public int maxProfit(int k, int[] prices) {
        
        if(prices == null)return 0;
        
        int N = prices.length;
        
        if(N == 0){
            return 0;
          }
           
          if(k >= N/2){
             int ans = 0;
              for(int i = 1 ; i < N ; i++){
                  if(prices[i] > prices[i-1]){
                      ans += prices[i] - prices[i - 1];
                  }
              }
              return ans;
           }
        
        int[][][] memo = new int[k][N][2];
        
        return helper(prices , 0 , k - 1 , 0,memo);
    }
    
    
    private int helper(int[]prices,int index, int k, int flag , int[][][]memo){
       
        if(index >= prices.length || k == -1 ){
            return 0;
        }
        
         if(memo[k][index][flag] != 0){
             return memo[k][index][flag];
         }
        
          int buy = 0 , noBuy = 0, sell = 0, noSell = 0 , max = 0;
        
          if(flag == 0){
              buy =  helper(prices , index + 1 ,k , 1 , memo) - prices[index];
              noBuy = helper(prices , index + 1,k , 0 , memo);
          }else{
              sell = helper(prices ,index + 1  , k - 1 , 0 , memo) + prices[index];
              noSell = helper(prices ,index + 1  , k, 1 , memo);
          } 
        max = Math.max(Math.max(buy,noBuy), Math.max(sell,noSell) );
        memo[k][index][flag] = max;
        return max;
     }
  
}