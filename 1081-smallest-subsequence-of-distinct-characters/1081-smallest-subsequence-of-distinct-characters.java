class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[128];
        boolean[] visited = new boolean[128];
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (char c : s.toCharArray()) {
            freq[c]--;

            if (visited[c]) {
                continue;
            }

            while (
                stack.length() > 0 &&
                stack.charAt(stack.length() - 1) > c &&
                freq[stack.charAt(stack.length() - 1)] > 0
            ) {
                char last = stack.charAt(stack.length() - 1);
                visited[last] = false;
                stack.setLength(stack.length() - 1);
            }

            stack.append(c);
            visited[c] = true;
        }

        return stack.toString();
    }
}