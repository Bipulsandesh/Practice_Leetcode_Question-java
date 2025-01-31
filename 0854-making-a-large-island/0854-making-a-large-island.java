public class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        HashMap<Integer, Integer> areaMap = new HashMap<>();
        int index = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, directions, index);
                    areaMap.put(index, area);
                    index++;
                }
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            set.add(grid[x][y]);
                        }
                    }
                    int area = 1;
                    for (int key : set) {
                        area += areaMap.get(key);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea == 0 ? n * n : maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, int[][] directions, int index) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int area = 1;
        for (int[] direction : directions) {
            area += dfs(grid, i + direction[0], j + direction[1], directions, index);
        }
        return area;
    }
}
