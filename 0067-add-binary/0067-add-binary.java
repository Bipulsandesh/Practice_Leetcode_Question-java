class Solution {
   public static String addBinary(String a, String b) {
        // Initialize result as a StringBuilder for efficiency
        StringBuilder result = new StringBuilder();
        
        // Start from the end of both strings
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get the current bits (0 if out of bounds)
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            // Calculate the sum of bits and carry
            int sum = bitA + bitB + carry;

            // Append the sum modulo 2 to result (0 or 1)
            result.append(sum % 2);

            // Update carry (sum divided by 2)
            carry = sum / 2;

            // Move to the next bit
            i--;
            j--;
        }

        // Reverse the result since we built it backwards
        return result.reverse().toString();
    }
}