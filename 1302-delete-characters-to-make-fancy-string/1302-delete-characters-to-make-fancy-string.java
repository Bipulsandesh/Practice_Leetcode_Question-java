class Solution {
    public String makeFancyString(String s) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = answer.length();

            // Only add if the last two characters are not the same as c
            if (len <= 1 || !(answer.charAt(len - 1) == c && answer.charAt(len - 2) == c)) {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}