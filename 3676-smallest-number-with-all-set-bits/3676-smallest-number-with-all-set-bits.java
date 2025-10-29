class Solution {
    public int smallestNumber(int n) {
        int msb = Integer.highestOneBit(n);
        return (msb<<1)-1;
    }
}