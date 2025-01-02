class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + isValid(words[i - 1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return res;
    }

    private int isValid(String s) {
        if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
            return 1;
        }
        return 0;
    }

    private boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
        }