class Solution {
    public int minimumLength(String s) {
        int n = s.length(), removableLen = 0;
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int frequency : freq) {
            if (frequency % 2 != 0) {
                removableLen += frequency - 1;
            } else if (frequency != 0) {
                removableLen += frequency - 2;
            }
        }

        return n - removableLen;
    }
}