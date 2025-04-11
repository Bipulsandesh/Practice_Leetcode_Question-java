class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        // Iterate through all numbers in the given range [low, high]
        for (int idx = low; idx <= high; idx++) {
            int num = idx;

            // Check for 2-digit numbers (i.e., 11 to 99)
            if (num > 10 && num <= 99) {
                // A 2-digit number is symmetric if both digits are equal
                // That means the number must be divisible by 11 (e.g., 11, 22, 33, ...)
                if (num % 11 == 0) ans++;
            }
            // Check for 4-digit numbers (i.e., 1000 to 9999)
            else if (num > 1000 && num <= 9999) {
                // Extract and sum the last two digits
                int first = num % 10;     // last digit
                num /= 10;
                first += num % 10;        // second last digit
                num /= 10;

                // Extract and sum the first two digits
                int second = num % 10;    // third digit from right
                num /= 10;
                second += num % 10;       // fourth digit (most significant)

                // If the sum of the first two digits equals the sum of the last two digits,
                // the number is symmetric
                if (first == second) {
                    ans++;
                }
            }
        }

        // Return the total count of symmetric numbers
        return ans;
    }
}
