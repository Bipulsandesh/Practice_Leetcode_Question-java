class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder();
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        char ch = x >= y ? 'a' : 'b';
        char hc = x >= y ? 'b' : 'a';
        int count = 0;

        for (int i=0;i<s.length();i++) {
            if (sb.length()>0 && s.charAt(i) == hc && sb.charAt(sb.length()-1) == ch) {
                sb.setLength(sb.length()-1);
                count += max;
            } else {
                sb.append(s.charAt(i));
            }
        }
        StringBuilder temp=new StringBuilder();
       for(int i=0;i<sb.length();i++)
       {
            if(temp.length()>0 && temp.charAt(temp.length()-1)==hc && sb.charAt(i)==ch)
            {
                    temp.setLength(temp.length()-1);
                    count+=min;
            }else
            {
                temp.append(sb.charAt(i));
            }
       }
        return count;
    }
}