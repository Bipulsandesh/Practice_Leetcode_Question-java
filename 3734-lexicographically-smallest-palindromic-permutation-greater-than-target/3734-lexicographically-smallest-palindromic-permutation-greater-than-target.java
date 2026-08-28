class Solution {
    int n;
    String ans="";
    char oddChar=' ';

    private boolean solve(StringBuilder sb,int[] freq,String target,int i,boolean greater)
    {
        //base case
        if(i==n/2)
        {
            StringBuilder nextHalf=new StringBuilder(sb);
            if(oddChar != ' ')
            {
                sb.append(oddChar);
            }
            String palindrome= sb.toString() + nextHalf.reverse().toString();

        if(greater)
        {
            ans=palindrome;
            return true;
        }
        else{
            int idx=i;

            while(idx<n)
            {
                if(palindrome.charAt(idx)>target.charAt(idx))
                {
                    ans=palindrome;
                    return true;
                }
                if(palindrome.charAt(idx)<target.charAt(idx))
                {
                    if(oddChar!=' ') sb.deleteCharAt(sb.length()-1);
                    return false;
                }

                idx++;
            }
        }

        if(oddChar!=' ') sb.deleteCharAt(sb.length()-1);

        return false;
    }

        for(char ch='a';ch<='z';ch++)
        {
            if(freq[ch-'a']<2) continue;
            if(!greater && ch<target.charAt(i)) continue;

            freq[ch-'a']-=2;
            sb.append(ch);

            boolean isGreater=greater || ch>target.charAt(i);

            if(solve(sb,freq,target,i+1,isGreater)){
                return true;
            }

            freq[ch-'a']+=2;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
    public String lexPalindromicPermutation(String s, String target) {
        n=s.length();
        int[] freq=new int[26];
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }

        int oddFreqCount=0;
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2!=0) {
                oddFreqCount++;
                if(oddFreqCount>1)
                {
                    return "";
                }
                oddChar=(char) ('a' + i);
            }
        }

    

        solve(new StringBuilder(),freq,target,0,false);

        return ans;
    }
}