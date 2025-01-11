class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int odds = 0;
        for (int count : freq) {
            if (count % 2 != 0)
                odds++;
        }
        
        return odds <= k;
    }
}