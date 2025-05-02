class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] rightClosestL = new int[n]; // Closest 'L' to the right
        int[] leftClosestR = new int[n];  // Closest 'R' to the left

        // Right to left pass for closest 'L'
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L')
                rightClosestL[i] = i;
            else if (dominoes.charAt(i) == '.')
                rightClosestL[i] = (i < n - 1) ? rightClosestL[i + 1] : -1;
            else
                rightClosestL[i] = -1;
        }

        // Left to right pass for closest 'R'
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R')
                leftClosestR[i] = i;
            else if (dominoes.charAt(i) == '.')
                leftClosestR[i] = (i > 0) ? leftClosestR[i - 1] : -1;
            else
                leftClosestR[i] = -1;
        }

        // Decide final direction for each domino
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int distL = rightClosestL[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - rightClosestL[i]);
            int distR = leftClosestR[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - leftClosestR[i]);

            if (distL == distR)
                result.append('.');
            else if (distL < distR)
                result.append('L');
            else
                result.append('R');
        }

        return result.toString();
    }
}