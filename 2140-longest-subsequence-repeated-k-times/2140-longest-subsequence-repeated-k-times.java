class Solution {
    private boolean isKRepeatedSubsequence(String s, String pattern, int k) {
        int pos = 0, matched = 0;
        for (char ch : s.toCharArray()) {
            if (ch == pattern.charAt(pos)) {
                pos++;
                if (pos == pattern.length()) {
                    pos = 0;
                    matched++;
                    if (matched == k) return true;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        List<Character> candidates = new ArrayList<>();
        for (int i = 25; i >= 0; i--)
            if (freq[i] >= k) candidates.add((char)(i + 'a'));

        Queue<String> q = new LinkedList<>();
        String ans = "";

        for (char ch : candidates) q.offer("" + ch);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) > 0))
                if (isKRepeatedSubsequence(s, curr, k)) ans = curr;
            if (curr.length() == 7) continue;
            for (char ch : candidates) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) q.offer(next);
            }
        }
        return ans;
    }
}