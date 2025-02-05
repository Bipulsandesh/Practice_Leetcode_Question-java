public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // If the strings are already equal, no swap is needed
        if (s1.equals(s2)) {
            return true;
        }

        // Find the indices of the differing characters
        int diffCount = 0;
        int[] diff = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount >= 2) {
                    return false;
                }
                diff[diffCount++] = i;
            }
        }

        // If there are more than 2 differing characters, it's impossible to make the strings equal with one swap
        if (diffCount != 2) {
            return false;
        }

        // Check if the differing characters can be swapped to make the strings equal
        return s1.charAt(diff[0]) == s2.charAt(diff[1]) && s1.charAt(diff[1]) == s2.charAt(diff[0]);
    }
}
