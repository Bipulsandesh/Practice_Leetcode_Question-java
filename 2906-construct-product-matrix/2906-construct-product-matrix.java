class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];

        int idx = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[idx++] = grid[i][j];

        int[] pre = new int[size];
        int[] suf = new int[size];
        Arrays.fill(pre, 1);
        Arrays.fill(suf, 1);

        for (int i = 1; i < size; i++)
            pre[i] = (int)((1L * pre[i - 1] * arr[i - 1]) % 12345);

        for (int i = size - 2; i >= 0; i--)
            suf[i] = (int)((1L * arr[i + 1] * suf[i + 1]) % 12345);

        int[] res = new int[size];
        for (int i = 0; i < size; i++)
            res[i] = (int)((1L * pre[i] * suf[i]) % 12345);

        int[][] ans = new int[m][n];
        idx = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ans[i][j] = res[idx++];

        return ans;
    }
}