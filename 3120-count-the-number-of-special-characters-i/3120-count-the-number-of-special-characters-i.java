class Solution {

    public int numberOfSpecialChars(String word) {

        // Tracks lowercase letters
        boolean[] lower = new boolean[26];

        // Tracks uppercase letters
        boolean[] upper = new boolean[26];

        // Traverse all characters
        for (char ch : word.toCharArray()) {

            // Lowercase character
            if (Character.isLowerCase(ch)) {

                lower[ch - 'a'] = true;

            } else {

                // Uppercase character
                upper[ch - 'A'] = true;
            }
        }

        // Stores special character count
        int count = 0;

        // Check matching characters
        for (int i = 0; i < 26; i++) {

            if (lower[i] && upper[i]) {

                count++;
            }
        }

        return count;
    }
}