class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int total = 0;

        for (int i = stoneValue.length - 1; i >= 0; i--) {
            total += stoneValue[i];

            int current = total - Math.min(
                s1,
                Math.min(s2, s3)
            );

            s3 = s2;
            s2 = s1;
            s1 = current;
        }

        int bob = total - s1;

        if (s1 > bob) {
            return "Alice";
        }

        if (s1 < bob) {
            return "Bob";
        }

        return "Tie";
    }
}