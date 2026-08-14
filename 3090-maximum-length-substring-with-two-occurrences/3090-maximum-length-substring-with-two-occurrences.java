class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        int []freq = new int[26];
        while(right < s.length()) {
            char ch = s.charAt(right);
            freq[ch-'a']++;
            while(freq[ch-'a'] > 2) {
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
            res = Math.max(res,right-left);
        }
        return res;
    }
}