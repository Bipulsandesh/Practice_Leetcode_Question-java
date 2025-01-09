class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        int len = pref.length();
        for (String word : words) {
            if (word.length() >= len && word.substring(0, len).equals(pref)) {
                ans++;
            }
        }
        return ans;
    }
}