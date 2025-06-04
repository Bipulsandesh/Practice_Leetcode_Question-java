class Solution {
    /*
      1. if numFriends==1 then no split is required so whole word would be answer
      2. Now let's say we have 2 strings s1 and s2 and s1 is prefix of s2 then s2 will be lexicographically
         largest string(e.g. s1=zbac, s2=zbacdef).
      3. Now try to maximize the length of a substring so for that initially we will assign 1 length substring
         to numFriends-1 no. of friends and remaining(word.length-(numFriends-1)) length substring will be assigned
         to last Friend.
      4. So now we will traverse over the string and try to find the largest lexicographically string of 
         length=word.length-(numFriends-1).
      5. while traversing the string in last we will be having sub-string with length<word.length-(numFriends-1)
         in that case if substring is lexicographically largest then that would be our answer (e.g.
          s1="ghfed", s2="z" here s2 is lexicographically largest).          
    */
    public String answerString(String word, int numFriends) {
        if(numFriends==1)return word;

        int n = word.length();
        int m = n - numFriends + 1;
        String ans = "";
        for(int i=0;i<n;i++){
            String ss = word.substring(i,Math.min(i+m,n));
            if(ss.compareTo(ans)>0)ans = ss;
        }
        return ans;
    }
}