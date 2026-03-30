class Solution {
    public boolean check(String s1, String s2, int idx) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        while(idx < s1.length()) {
            freq1[s1.charAt(idx)-'a']++;
            freq2[s2.charAt(idx)-'a']++;
            idx += 2;
        }
        for(int i=0;i<26;i++) {
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    public boolean checkStrings(String s1, String s2) {
        return check(s1,s2,0) && check(s1,s2,1);
    }
}