class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] res = new int[rows - k + 1][cols - k + 1];

        for (int r = 0; r <= rows - k; r++) {
            for (int c = 0; c <= cols - k; c++) {

                ArrayList<Integer> window = new ArrayList<>();

                for (int i = 0; i < k; i++)
                    for (int j = 0; j < k; j++)
                        window.add(grid[r+i][c+j]);

                Collections.sort(window);

                int minDiff = Integer.MAX_VALUE;
                for (int i = 0; i < window.size() - 1; i++) {
                    int d = window.get(i+1) - window.get(i);
                    if (d > 0)
                        minDiff = Math.min(minDiff, d);
                }

                res[r][c] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
            }
        }

        return res;
    }
}