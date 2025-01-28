class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows, cols;

    public int findMaxFish(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxFish = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0) {
            return 0;
        }

        int fish = grid[x][y];
        grid[x][y] = 0; // Mark as visited

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            fish += dfs(grid, newX, newY);
        }

        return fish;
    }
}
