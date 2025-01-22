class Solution {
    public int trailingZeroes(int n) {
        int a = 0;

        for (int i = 1; true; i++) {
            int pow = pow(5, i);
            if (n / pow == 0) {
                break;
            } else {
                a += n / pow;
            }
        }
        return a;
    }

    public int pow(int num, int power) {
        int res = 1;
        if (power == 0) return 1;
        for (int i = 0; i < power; i++) {
            res = res * num;
        }
        return res;
    }
}