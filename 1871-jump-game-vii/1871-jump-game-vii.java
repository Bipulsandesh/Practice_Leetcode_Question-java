class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n-1)!='0') return false;

        // suffix array to store suffix sum of count of true indices
        int[] suffixT = new int[n];
        suffixT[n-1] = 1;

        for(int i = n-2 ; i>-1 ; i--){
            char ch = s.charAt(i);

            suffixT[i] = suffixT[i+1];

            if(ch=='0'){
                // calculating how many true indices are in the range
                // for each i that is 0, check the range i+minJump to i+maxJump

                int left = i+minJump<n ? suffixT[i+minJump] : 0 ;
                int right = i+maxJump+1<n ? suffixT[i+maxJump+1] : 0;
                if(left-right!=0) suffixT[i]++;
            }
        }
        // checks if the first index is true or not
        return suffixT[0]!=suffixT[1];
    }
}