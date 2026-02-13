class Solution {

    // BIAS ensures we don't have negative numbers when packing two values into a long.
    // 1L << 18 is large enough to handle typical string length constraints.
    private static final long BIAS = 1L << 18;
    private static final int SHIFT = 32;

    //Packs two integers (x, y) into a single 64-bit long to use as a HashMap key.
    //This is more performant than creating a "Pair" object or a String key.

    private static long pack(long x, long y) {
        // (x + BIAS) is shifted to the high 32 bits, (y + BIAS) stays in the low 32 bits.
        return ((x + BIAS) << SHIFT) | (y + BIAS);
    }
    private static int has1(String s) {
        int max = 1;
        int len = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, len);
    }

    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        // Start with the longest single-character substring as the baseline.
        int ans = has1(s);

        // Maps to store the first occurrence of a specific prefix difference.
        // abc: Handles A == B == C
        // ab:  Handles A == B (with C being constant)
        // bc:  Handles B == C (with A being constant)
        // ca:  Handles C == A (with B being constant)
        Map<Long, Integer> ab = new HashMap<>();
        Map<Long, Integer> bc = new HashMap<>();
        Map<Long, Integer> ca = new HashMap<>();
        Map<Long, Integer> abc = new HashMap<>();

        // Initialize with 0 counts at index -1 (before the string starts).
        abc.put(pack(0, 0), -1);
        ab.put(pack(0, 0), -1);
        bc.put(pack(0, 0), -1);
        ca.put(pack(0, 0), -1);

        int A = 0, B = 0, C = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a') A++;
            else if (ch == 'b') B++;
            else if (ch == 'c') C++;

            long key;

            // CASE: All three characters are equal (A == B == C)
            // If (B-A) and (C-A) are the same at two different indices, 
            // then the counts of A, B, and C increased by the same amount in between.
            key = pack(B - A, C - A);
            if (abc.containsKey(key)) {
                ans = Math.max(ans, i - abc.get(key));
            } else {
                abc.put(key, i);
            }

            // CASE: Two characters are equal (A == B) and third (C) is not present
            // We pack (A - B) and current count of C. 
            // If current C matches a previous C, it means no 'c' appeared in the interval.
            key = pack(A - B, C);
            if (ab.containsKey(key)) {
                ans = Math.max(ans, i - ab.get(key));
            } else {
                ab.put(key, i);
            }

            // CASE: Two characters are equal (B == C) and third (A) is not present
            key = pack(B - C, A);
            if (bc.containsKey(key)) {
                ans = Math.max(ans, i - bc.get(key));
            } else {
                bc.put(key, i);
            }

            // CASE: Two characters are equal (C == A) and third (B) is not present
            key = pack(C - A, B);
            if (ca.containsKey(key)) {
                ans = Math.max(ans, i - ca.get(key));
            } else {
                ca.put(key, i);
            }
        }

        return ans;
    }
}