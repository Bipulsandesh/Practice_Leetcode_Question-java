class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int MOD = 1_000_000_007;
        
        // Convert t to the appropriate type
        // The problem statement has t as int, but it can be up to 10^9
        // so we should use long for calculations
        long transformations = t;
        
        // Let's track how each character grows after one transformation
        // and fast-power our way to t transformations
        
        // Matrix of transformation growth rates
        // For each character i, how many characters will it produce after 1 transformation
        long[][] transformMatrix = new long[26][26];
        for (int i = 0; i < 26; i++) {
            // When character 'a'+i transforms, it becomes nums[i] consecutive characters
            for (int j = 0; j < nums.get(i); j++) {
                // Get the produced character (with wrap-around)
                int nextChar = (i + j + 1) % 26;
                transformMatrix[i][nextChar]++;
            }
        }
        
        // Use matrix exponentiation to compute the result after t transformations
        long[][] resultMatrix = matrixPower(transformMatrix, transformations, MOD);
        
        // Calculate the final length
        long totalLength = 0;
        for (char c : s.toCharArray()) {
            int charIndex = c - 'a';
            
            // Count how many characters this one will produce
            long charContribution = 0;
            for (int i = 0; i < 26; i++) {
                charContribution = (charContribution + resultMatrix[charIndex][i]) % MOD;
            }
            
            totalLength = (totalLength + charContribution) % MOD;
        }
        
        return (int) totalLength;
    }
    
    // Matrix multiplication function
    private long[][] multiplyMatrix(long[][] A, long[][] B, int MOD) {
        int n = A.length;
        long[][] result = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        
        return result;
    }
    
    // Matrix power function using binary exponentiation
    private long[][] matrixPower(long[][] matrix, long power, int MOD) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        
        // Initialize result as identity matrix
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        
        // Binary exponentiation
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrix(result, matrix, MOD);
            }
            matrix = multiplyMatrix(matrix, matrix, MOD);
            power /= 2;
        }
        
        return result;
    }
}