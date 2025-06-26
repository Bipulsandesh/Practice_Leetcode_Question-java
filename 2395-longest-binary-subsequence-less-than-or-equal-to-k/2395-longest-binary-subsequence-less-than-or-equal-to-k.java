class Solution {
    public int countZero(String s)
    {
     int countZero = 0;    
     for(char ch : s.toCharArray())
     {
      if(ch=='0')
      countZero++;
     }
      return countZero;
    }


    public int longestSubsequence(String s, int k) {
     int n = s.length();    
     int countZeros = countZero(s);
     int pow = 1;
     int currVal = 0; 
     int validOnes = 0 ;
     for(int i = n-1; i>=0; i--)
     {
      if(s.charAt(i)=='1')
      {
         if((currVal + pow) > k)
         {
           continue; 
         } 
        validOnes++; 
        currVal += pow;       
      } 

      pow = pow<<1;
      if(pow>k)
      break;
     }
      return countZeros + validOnes;
    }
}