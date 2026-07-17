import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] cntDiv = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                cntDiv[i] += freq[j];
            }
        }

        long[] exact = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            long c = cntDiv[i];
            exact[i] = c * (c - 1) / 2;
            for (int j = i + i; j <= max; j += i) {
                exact[i] -= exact[j];
            }
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int l = 1, r = max;
            while (l < r) {
                int m = (l + r) >>> 1;
                if (prefix[m] > q) r = m;
                else l = m + 1;
            }
            ans[i] = l;
        }
        return ans;
    }
}