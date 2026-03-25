class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] a = new long[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                a[i][j] = grid[i][j];
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j > 0) a[i][j] += a[i][j-1];
                if(i > 0) a[i][j] += a[i-1][j];
                if(i > 0 && j > 0) a[i][j] -= a[i-1][j-1];
            }
        }
        for(int i = 0 ; i < m-1; i++){
            if(a[m-1][n-1] - a[i][n-1] == a[i][n-1]) return true;
        }
        for(int i = 0 ; i < n-1 ; i++){
            if(a[m-1][n-1] - a[m-1][i] == a[m-1][i]) return true;
        }
        return false;
    }
}