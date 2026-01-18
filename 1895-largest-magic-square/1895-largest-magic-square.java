class Solution {
    public int largestMagicSquare(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int maxSize = Math.min(n,m);
        int res =1;
        
        for(int i=2;i<=maxSize;i++){
            if(createSquare(grid,i)){
                res = Math.max(res,i);
            }
        }
        return res;
    }

    Boolean createSquare(int[][] grid, int size){
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<=n-size;i++){
            for(int j=0;j<=m-size;j++){
                if(checkIsMagic(i,j,size,grid)){
                    return true;
                }
            }
        }
        return false;
    }

   boolean checkIsMagic(int r, int c, int size, int[][] grid) {

    int finalSum = 0;
    for (int j = c; j < c + size; j++) {
        finalSum += grid[r][j];
    }

    // rows
    for (int i = r; i < r + size; i++) {
        int sum = 0;
        for (int j = c; j < c + size; j++) {
            sum += grid[i][j];
        }
        if (sum != finalSum) return false;
    }

    // columns
    for (int j = c; j < c + size; j++) {
        int sum = 0;
        for (int i = r; i < r + size; i++) {
            sum += grid[i][j];
        }
        if (sum != finalSum) return false;
    }

    // main diagonal
    int d1 = 0;
    for (int i = 0; i < size; i++) {
        d1 += grid[r + i][c + i];
    }
    if (d1 != finalSum) return false;

    // anti-diagonal
    int d2 = 0;
    for (int i = 0; i < size; i++) {
        d2 += grid[r + i][c + size - 1 - i];
    }
    if (d2 != finalSum) return false;

    return true;
}

}