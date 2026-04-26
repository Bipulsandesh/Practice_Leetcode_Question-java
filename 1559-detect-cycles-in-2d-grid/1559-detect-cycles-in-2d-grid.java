class Solution {
    private final int[] dir = {-1, 0, 1, 0, -1};
    private boolean cycle(char[][] g, char unvisited, char visited, int i, int j, int prev_i, int prev_j) {
        g[i][j] = visited;
        for (int d = 0; d < 4; d++) {
            int x = i + dir[d], y = j + dir[d + 1];
            if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && !(x == prev_i && y == prev_j)) {
                if (g[x][y] == visited) return true;
                if (g[x][y] == unvisited && cycle(g, unvisited, visited, x, y, i, j)) return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] g) {
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++)
                if (g[i][j] >= 'a' && g[i][j] <= 'z')
                    if (cycle(g, g[i][j], (char) (g[i][j] - 'a' + 'A'), i, j, -1, -1)) return true;
        return false;
    }
}