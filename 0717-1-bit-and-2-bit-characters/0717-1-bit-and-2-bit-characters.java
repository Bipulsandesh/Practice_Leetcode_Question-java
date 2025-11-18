class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while(i < n){
            if(bits[i] == 1) i+=2;
            else{
                if(i == n-1) return true;
                i++;
            }
        }
        return false;
    }
}