class Solution {
    public int maxProduct(int n) {
        int d1 = 0;
        int d2 = 0;

        while (n > 0) {
            int rem = n % 10;

            if (rem >= d1) {
                d2 = d1;
                d1 = rem;
            } else if (rem > d2) {
                d2 = rem;
            }

            n /= 10;
        }

        return d1 * d2;
    }
}