class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int left=0,right=0;
        int a=0,b=0,c=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else if(ch=='c') c++;
            //while the condition is true keep updating the answer and keep triming from 
            //left.
            while(a>0 && b>0 && c>0 ){
                count+=s.length()-right;
                char ch1=s.charAt(left);
                if(ch1=='a') a--;
                else if(ch1=='b') b--;
                else if(ch1=='c') c--;
                left++;
            }
            right++;
        }
        return count;
    }
}