import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int st = -1, end = -1;

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == ch) {
                    if (st == -1) st = j;
                    end = j;
                }
            }

            if (st == -1 || st == end) continue;

            HashSet<Character> set = new HashSet<>();
            for (int j = st + 1; j < end; j++) {
                set.add(s.charAt(j));
            }
            ans += set.size();
        }
        return ans;
    }
}