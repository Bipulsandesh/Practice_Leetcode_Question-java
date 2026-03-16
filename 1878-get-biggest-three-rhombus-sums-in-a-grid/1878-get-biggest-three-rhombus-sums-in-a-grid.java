import java.util.*;

class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                add(set, grid[r][c]);

                for (int k = 1; ; k++) {

                    if (r-k < 0 || r+k >= m || c-k < 0 || c+k >= n)
                        break;

                    int sum = 0;

                    int x = r - k;
                    int y = c;

                    for (int i = 0; i < k; i++)
                        sum += grid[x + i][y + i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r + i][c + k - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r + k - i][c - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[r - i][c - k + i];

                    add(set, sum);
                }
            }
        }

        int[] res = new int[set.size()];
        int i = res.length - 1;

        for (int val : set)
            res[i--] = val;

        return res;
    }

    private void add(TreeSet<Integer> set, int val) {
        set.add(val);
        if (set.size() > 3)
            set.pollFirst();
    }
}