class Solution {
    public int possibleStringCount(String word) {
    char prev = ' ';
    int count = 0, ans = 1;    
    for(char ch : word.toCharArray())
    {
       if(ch!=prev)
       {
        if(count>1)
        ans += count-1;
        count = 1; 
       }
       else
       count++; 

       prev = ch;
    }    
    return ans + count - 1 ;

    }
}