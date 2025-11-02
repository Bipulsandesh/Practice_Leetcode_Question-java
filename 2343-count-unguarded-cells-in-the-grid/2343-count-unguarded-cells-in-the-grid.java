class Solution {

    private static int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    private boolean isInside(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int[][] grid = new int[n][m];
        // 0 - empty
        // 1 - guard
        // 2 - wall
        // 3 - guarded
        int unmarked = n * m;
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
            unmarked--;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
            unmarked--;
        }

        for (int[] guard : guards) {
            for (int dir = 0; dir < 4; dir++) {
                int x = guard[0] + directions[dir][0];
                int y = guard[1] + directions[dir][1];

                // stop if there is a guard or wall
                while (isInside(x, y, n, m) && grid[x][y] != 1 && grid[x][y] != 2) {
                    if (grid[x][y] == 0) {
                        unmarked--;
                        grid[x][y] = 3;
                    }
                    x += directions[dir][0];
                    y += directions[dir][1];
                }
            }
        }

        return unmarked;
    }
}