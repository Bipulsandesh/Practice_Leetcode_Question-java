class Solution {
    private void incrementPalindrome(StringBuilder a) {
        int L = (a.length()-1)/2, R = a.length()/2;
        while(L >= 0) {
            if(a.charAt(L) == '9') {
                // Case It is a nine: we cannot increment it so move on to the next outer digit that we can (possibly) increment.
                // We set this to 0 because look at the following testcase: 2992
                // The highest is 3003, if we don't modify this to be 0 then it would return 3993
                // Basically set to the lowest possible digit
                a.setCharAt(L, '0');
                a.setCharAt(R, '0');
                L--; R++;
            }else {
                // This is so nice there is no edge case needed for incrementPalindrome() unlike in decrementPalindrome()
                // Case Not a nine: increment and return
                char ch = (char) (a.charAt(L) + 1);
                a.setCharAt(L, ch);
                a.setCharAt(R, ch);
                return;
            }
        }
        // It's all 9s and everything has also been set to 0
        a.setCharAt(0, '1');
        a.append('1');
    }
    private long factorial(int n) {
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    private long permWithoutLeadingZero(CharSequence a) {
        int[] freq = new int[26];
        for(int i = 0; i < a.length(); i++) {
            freq[a.charAt(i)-'0']++;
        }
        // perms that doesnt have a leading zero is
        // for starting digit as 1 -> 9:
        //    freq[starting digit] --
        //    perms += perms(a[1...], freq)
        //    freq[starting digit] ++
        //    here ^^ we didnt account for duplicate permutations
        //    so we divide by the factorial(frequency of each character)
        long perms = 0;
        long fc = factorial(a.length()-1); // ALL perms(a[1...])
        for(int i = 1; i <= 9; i++) {
            if(freq[i] == 0) continue;
            // use as start
            freq[i]--;
            long currPerms = fc;
            for(int j = 0; j <= 9; j++) {
                currPerms /= factorial(freq[j]); // filter out duplicates
            }
            perms += currPerms;
            freq[i]++;
        }
        return perms;
    }
    private static final long BIGMOD = (long) (Math.pow(2,60))+33; // big prime
    private long hashStr(StringBuilder builder) {
        long res = 0, p = 1;
        int[] freq = new int[10];
        // get all freq of number
        for(int i = 0; i < builder.length(); i++) {
            freq[builder.charAt(i)-'0']++;
        }
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j < freq[i]; j++) {
                // loop through each character starting from 0 -> 9
                // step-by-step according to their frequency
                // this is equivalent to looping through the chars of
                // sorted(builder)
                res = (res+p*(i+1))%BIGMOD;
                p = (p*11)%BIGMOD;
            }
        }
        return res;
    }
    public long countGoodIntegers(int n, int k) {
        if(n <= 2) { // Manual, case n = 1 is actually same as n = 2
            switch(k) {
            case 1:
                return 9;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            default:
                return 1;
            }
        }
        StringBuilder s = new StringBuilder();
        s.append('1').append("0".repeat(n-2)).append('1');
        Set<Long> doneSet = new HashSet<>();
        long cnt = 0;
        while(s.length() == n) { // If the number has overflowed to the next digit,
                                // then we've looped through every palindrome
            if((Long.parseLong(s.toString()) % k) == 0) {
                // Here we hash it into a long, you could also do sort a string like
                // char[] chars = s.toString().toCharArray();
                // Arrays.sort(chars);
                // String sorted = new String(chars);
                long hash = hashStr(s);
                // Check if we've gone through this permutation before, if yes ignore it. If not, add all perms of it.
                if(!doneSet.contains(hash)) {
                    doneSet.add(hash);
                    cnt += permWithoutLeadingZero(s);
                }
            }
            incrementPalindrome(s); // Go to the next palindrome number
        }
        return cnt;
    }
}