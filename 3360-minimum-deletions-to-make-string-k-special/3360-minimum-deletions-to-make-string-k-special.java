class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        int minDel = Integer.MAX_VALUE;
        for (int base = 0; base < 26; base++) {
            if (freq[base] == 0)
                continue;
            int del = 0;
            int baseFreq = freq[base];

            for (int comp = 0; comp < 26; comp++) {
                if (freq[comp] == 0)
                    continue;
                if (base == comp)
                    continue;

                int compFreq = freq[comp];
                if (compFreq < baseFreq) {
                    del += compFreq;
                } else if (compFreq - baseFreq > k) {
                    del += compFreq - baseFreq - k;
                }
            }

            minDel = Math.min(minDel, del);
        }

        return minDel;
    }
}