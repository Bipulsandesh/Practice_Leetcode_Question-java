class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(grid[i], 0, result[i], 0, columns);
        }
        int layerNum = Math.min(rows, columns) / 2;
        for (int layer = 0; layer < layerNum; layer++) {
            int perimeter = 2 * (rows + columns - 4 * layer) - 4;
            int rotateStep = k % perimeter;
            for (int step = 0; step < rotateStep; step++) {
                int temp = result[layer][layer];
                for (int col = layer + 1; col < columns - layer; col++) {
                    result[layer][col - 1] = result[layer][col];
                }
                for (int row = layer + 1; row < rows - layer; row++) {
                    result[row - 1][columns - layer - 1] = result[row][columns - layer - 1];
                }
                for (int col = columns - layer - 2; col >= layer; col--) {
                    result[rows - layer - 1][col + 1] = result[rows - layer - 1][col];
                }
                for (int row = rows - layer - 2; row >= layer; row--) {
                    result[row + 1][layer] = result[row][layer];
                }
                result[layer + 1][layer] = temp;
            }
        }
        return result;
    }
}