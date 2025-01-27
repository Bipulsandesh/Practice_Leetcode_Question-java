public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // Find the common prefix of left and right
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Return the common prefix
        return left << shift;
    }
}