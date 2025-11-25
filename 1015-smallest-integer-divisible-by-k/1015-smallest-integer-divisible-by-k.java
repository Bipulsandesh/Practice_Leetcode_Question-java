
class Solution {
    public int smallestRepunitDivByK(int k) {
            int rem=1,n=1,digit_count=1;
            if(k%2==0 || k%5==0) return -1;
            while(rem%k!=0){
                n=rem*10+1;
                rem=n%k;
                digit_count++;
            } 

            return digit_count;
    }
}