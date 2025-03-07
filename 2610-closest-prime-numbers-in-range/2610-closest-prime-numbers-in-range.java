import java.util.*;

public class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to mark prime numbers
        boolean[] isPrime = sieve(right);

        // Step 2: Collect primes within the given range
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1};  // Not enough primes to form a pair
        }

        int minGap = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int gap = primes.get(i + 1) - primes.get(i);
            if (gap < minGap) {
                minGap = gap;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }

    // Sieve of Eratosthenes to find prime numbers up to n
    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // Driver code
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.closestPrimes(10, 19))); // Output: [11, 13]
        System.out.println(Arrays.toString(solution.closestPrimes(4, 6)));   // Output: [-1, -1]
    }
}

