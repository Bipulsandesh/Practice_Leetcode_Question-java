class Solution {
    public boolean isPowerOfThree(int n) {
// Maximum power of a triple in an Integer
        int maxPowerOfThree = 1162261467;

        // Check that the number is positive and that the maximum power of the triple is divisible by n without remainder
        return n > 0 && maxPowerOfThree % n == 0;
    }
}