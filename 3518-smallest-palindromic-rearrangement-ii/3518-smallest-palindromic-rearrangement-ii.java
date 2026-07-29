import java.util.*;

class Solution {

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        // Step 1: middle character
        String mid = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                mid = "" + (char)(i + 'a');
                freq[i]--;
                break;
            }
        }

        // Step 2: half frequencies
        int[] half = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long count = countPermutations(half, k);

                if (k > count) {
                    k -= count;
                    half[c]++;
                } else {
                    left.append((char)(c + 'a'));
                    break;
                }
            }
        }

        if (left.length() != halfLen) return "";

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }

    // ✅ FIXED counting using combinations
    private long countPermutations(int[] freq, int limit) {
        int total = 0;
        for (int f : freq) total += f;

        long res = 1;

        for (int f : freq) {
            if (f == 0) continue;
            res = res * comb(total, f, limit) ;
            if (res > limit) return limit;
            total -= f;
        }

        return res;
    }

    // nCk with cap
    private long comb(int n, int k, int limit) {
        if (k > n) return 0;
        k = Math.min(k, n - k);

        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
            if (res > limit) return limit;
        }
        return res;
    }
}