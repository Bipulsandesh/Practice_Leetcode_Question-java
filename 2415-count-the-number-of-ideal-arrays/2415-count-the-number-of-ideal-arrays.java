class Solution {
    public static final int MOD = (int)1e9 + 7;
    public static final int LIM = (int)1e4;
    static List<Integer>[] primeExponents = getPrimeExponents(LIM);
    public static long[] modInverse;
    static {
        modInverse = new long[32 - Integer.numberOfLeadingZeros(LIM)];
        for(int i = 0; i < modInverse.length; i++) {
            modInverse[i] = modPow(i, MOD-2);
        }
    }
    public int idealArrays(int n, int maxValue) {
    /*
        arr[i-1] must divide arr[i] for all indices
        this means that arr[i] >= arr[i-1] for all indices, and therefore any ideal array is non-decreasing
        the statement is also equivalent to a[i] must be a multiple of a[i-1] for all indices

        investigate how many ideal arrays can be formed when starting with a number x from 1 to maxValue

            for any x, can always form the trivial ideal array [x, x, x, .... for n x's]
            could also choose n-1 x's and then another number that is a multiple of x
                this only works if x <= maxValue/2
            
            since ideal array construction only ever relies on the previous value, can first count ideal prefixs
            or smaller ideal arrrays, so observe endings instead as those constrain that which can come before, while starts can diverge along paths
            as long as they dont exceed max

        count number of ideal arrays of size i that end at x
            let f[i][x] be the number of ideal subarrays of length i ending with the number x.
            This is similar to solving idealArrays(i-1, x), as all indices before the x have to be <= x,
            making x act as a max for the prefix of length i-1, and obviously this prefix must be ideal in its own right.

            Difference between the two is that an ideal arrray of length i-1 with maxValue = x doesn't necessarily have to
            end in a divisor of x, and if it doesn't then it can't be followed up by an x at the ith index.

            so count only prefixs that end in divisors of x as potential prefix's to the x array.
            This gives f[i][x] = sum(f[i-1][d]) for all d | x.
            f has a base case of f[1][x] = 1, as only a single subarray can contain just x
            this means f[2][x] = sum(f[1][d]) for all d | x. By the base case f[2][x] = sum(1) for all d | x = count of divisors of x = d(x)
            so f[2][x] = d(x),
           f[3][x] would be sum(d(i)) for all i | x, and in general f[i][x] could theoretically be expressed as a nested sum of divisor counting functiions

           this seems very inefficient in current form tthough (maybe number theoretic property/simplification makes this better) so just use 
           recurrence sum as dp relation 
            f[i][x] = sum(f[i-1][d]) for all d | x

            for some multiple of x k*x, k*x has all the divisors tthat x has
            if we let k be coprime to x, then the divisors of k and x are independent other than trivial = 1
            so for coprime x and k have f[i][k*x] = sum(f[i-1][d]) for all d | k*x =  sum(f[i-1][d]) for all d | x + sum(f[i-1][d]) for all d | k  - f[i-1][1]
            = f[i][x] + f[i][k] - f[i-1][1]
            
            this isn't fully correct as we've lost all divisors whiich come from combining parts of x and k.
            It seems like f could be multiplicative (with respect to second argument (and number theory def for only coprime inputs))
            if thiis is the case, for a coprime k and x f[i][x*k] = f[i][x]*f[i][k] for coprime x and k

            this won't work when x is a prime power though, as cannot get coprime factors as all have same prime in it.
            
            so observe special case f[i][p^k] for some prime p, integer k
            f[i][p^k] = sum(f[i-1][d]) for all d | p^k. Divisorrs of p^k are 1, p, p^2, ... p^(k-1), p^k.
            f[i][p^k] = sum(f[i-1][p^j]) for j = 0 to k = f[i-1][p^k] + sum(f[i-1][p^j]) for j = 0 to k-1 = f[i-1][p^k] + f[i][p^(k-1)]

            this will worrk for all k > 0, so just need base case of p^0 = 1, 
            f[i][1] is cntt of arrays of lenn i ending in 1, ttrivially iis going to be a single array of repeated ones so
            f[i][1] = 1

            this gives f[i][p] = f[i-1][p] + 1 = 1 + 1 + f[i-2][p].... = i
            f[i][p^2] = f[i][p] + f[i-1][p^k] = f[i][p] + f[i-1][p] + f[i-2][p^k].... = sum j = 0 to i of (f[j][p]) = sum j = 0 to i (j) = triangular for i
            f[i][p^3] = sum of triangulars for j through 0 to i, for p^4 some of p^3s etc. This sum of sum of triangulars is given by a binomial relationshiip for m-gon numbers
            
            this gives general closed/non-recursive formula for p^k as f[i][p^k] = (i + k - 1 choose k)

            having all f[i][p^k] means all others f[i][x] can be expressed as products of their prime factor/powers
            by the multiplicativity of f.

            f[i][x] = (i + k_0 - 1 choose k)*(i + k_1 - 1 choose k),.... for k_j = the jth exponent in prime factorization of x
            
            since the answer involves any of them being a possible end for an n length arr, take the sum throughoout x = 1 to max of f[n][x] (let base case of 1 = 1)

            so res = 1 + sum[x = 2 to max]((i + k_0 - 1 choose k_0)*(i + k_1 - 1 choose k_1),.... for k_j = the jth exponent in prime factorization of x))

            the terms will all be of the form 
            (i + k - 1 choose k), with the min possible k being 1 (exp of 1), max possible k being floor(logBase2(Max)) as this is the max exp on a 2 and since 2 is 
            the lowest prime, on everything else aswell

            so only need to calculate floor(logBase2(max)) different binomial terms

            after terms are calculated, just need to iterate through max different sum terms.

            each term involves a product of a numbere of binnomiiials equal tto that of the count of distinct prime factors i has
            the number of distinct prime factors for an int x is on average ~ log(log(x)), so 

            each product term shoudl take log(log(x)) to calculate, and for x ranging 0 to max this gives a sum complexity of 

            O(max*log(log(Max)))

            this has eliminated all i-1 from the recurrence, effectively making an indepent recurrence in the single index
            
           */
            if(maxValue == 1) return 1;
            int log2Max = 31 - Integer.numberOfLeadingZeros(maxValue);

            long[] binomials = new long[log2Max + 1];
            binomials[0] = 1;

            //binomials[k] = (n + k - 1 choose k), so start with (n-1 choose 0) = 1 and use recurrence for (a choose b) = a/b * (a-1 choose b-1)
            for(int k = 1; k <= log2Max; k++) {
                binomials[k] = (binomials[k-1] * (((n+k-1) *  modInverse[k]) % MOD)) % MOD;
            }
            
            long res = 1L;
            for(int x = 2; x <= maxValue; x++) {
                long term = 1;
                for(int power : primeExponents[x]) {
                    term = (term * binomials[power]) % MOD;
                }
                res = (res + term) % MOD;
            }
            return (int)res;

    }

    private static int[] sieveSmallestPFact(int lim) {
        int[] smallestPFactor = new int[lim + 1];
        smallestPFactor[1] = 1;
        for(int i = 3; i <= lim; i += 2) {
            smallestPFactor[i-1] = 2;
            if(smallestPFactor[i] != 0) continue; //is composite
            smallestPFactor[i] = i;
            for(int j = i * i; j <= lim; j += 2*i) {
                if(smallestPFactor[j] == 0) smallestPFactor[j] = i;
            }
        }
        if(lim % 2 == 0) smallestPFactor[lim] = 2;
        return smallestPFactor;
    }

    private static List<Integer>[] getPrimeExponents(int n) {
        int[] smallestPFactor = sieveSmallestPFact(n);
        List<Integer>[] pExponents = new ArrayList[n+1];
        pExponents[1] = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(smallestPFactor[i] == i) {
                pExponents[i] = new ArrayList<>(Arrays.asList(1));
                continue;
            }
            int f1 = smallestPFactor[i], f2 = i/f1;
            int multiplicity = 1;
            while(f2 % smallestPFactor[i] == 0) {
                f2 /= smallestPFactor[i];
                f1 *= smallestPFactor[i];
                multiplicity++;
            }
            pExponents[i] = new ArrayList<>(pExponents[f2]);
            pExponents[i].add(multiplicity);
        }
        return pExponents;
    }

    private static long modPow(int base, int exp) {
        long res = 1, multiplier = base;
        while(exp > 0) {
            if((exp & 1) == 1) res = (res * multiplier) % MOD;
            multiplier = (multiplier * multiplier) % MOD;
            exp >>= 1;
        }
        return res;
    }
}