class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;       // Number of rows
        int m = matrix[0].length;    // Number of columns

        boolean firstRow = false;    // To check if the first row needs to be zeroed
        boolean firstCol = false;    // To check if the first column needs to be zeroed

        // Step 1: Mark zeros in the first row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true; // Mark the first row
                    if (j == 0) firstCol = true; // Mark the first column
                    matrix[i][0] = 0;           // Mark row i
                    matrix[0][j] = 0;           // Mark column j
                }
            }
        }

        // Step 2: Use the marks to set other cells to zero
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Handle the first row
        if (firstRow) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle the first column
        if (firstCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}