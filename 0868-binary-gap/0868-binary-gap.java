class Solution {
    public int binaryGap(int n) {
        int last = -1;   // Index of the previous '1'
        int index = 0;  // Current bit position
        int maxGap = 0;

        while (n > 0) {
            // Check if the current bit is 1
            if ((n & 1) == 1) {
                if (last != -1) {
                    // Update maxGap with distance between current and last '1'
                    maxGap = Math.max(maxGap, index - last);
                }
                last = index;
            }
            // Move to the next bit
            n >>= 1;
            index++;
        }

        return maxGap;
    }
}