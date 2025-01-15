class Solution {
    public int minimizeXor(int num1, int num2) {
        int res = 0;
        int setBits = Integer.bitCount(num2);
        //Set the Most Significant Bits
        for(int i=31; (setBits > 0 && i >= 0); i--){
            if(((num1>>i)&1) != 0){
                res = res | 1 << i;
                setBits--;
            }
        }
        //Set the Least Significant Bits 
        for(int i = 0; (setBits > 0 && i <= 31); i++){
            if((res & (1<<i)) == 0){
                res = res | (1<<i);
                setBits--;
            }
        }
        
        return res;
    }
}