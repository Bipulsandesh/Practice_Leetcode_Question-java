class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int tn = m * n, tc = 0;
        int[] a = new int[tn];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[index++] = grid[i][j];
            }
        }

        Arrays.sort(a);
        int mid = tn / 2;
        int median = a[mid];

        for (int value : a) {
            if (Math.abs(value - median) % x != 0) {
                return -1;
            }
            tc += Math.abs(value - median) / x;
        }

        return tc;
    }
}
