import java.util.*;

class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = new HashSet<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)
        );

        int ans = 0;
        for (int num = left; num <= right; num++) {
            if (primes.contains(Integer.bitCount(num))) {
                ans++;
            }
        }

        return ans;
    }
}