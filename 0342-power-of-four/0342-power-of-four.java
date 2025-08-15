class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        double x = Math.log10(n) / Math.log10(4);
        return x == (int)x;
    }
}