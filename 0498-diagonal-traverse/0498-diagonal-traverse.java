class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = 0;
        int[] res = new int[m*n];
        int resp = 0;
        boolean d =  true;;
        while (i < m && j < n) {
            res[resp] = mat[i][j];
            resp += 1;
            if (i == 0 && j == n - 1 && d) {
                i += 1;
                d =  false;
            }
            else if ( i == m - 1 && j == 0 &&  !d) {
                j += 1;
                d =  true;
            }
            else if ( i == m - 1 && j == n - 1){
                break;
            }
            else if ( i == 0 && d) {
                j += 1;
                d =  false;
            }
            else if ( j == 0 &&  !d ){
                i += 1;
                d =  true;
            }
            else if ( i == m - 1 &&  !d ) {
                j += 1;
                d =  !d;
            }
            else if ( j == n - 1 && d ) {
                i += 1;
                d =  !d;
            }
            else {
                if ( d ) {
                    i -= 1;
                    j += 1;
                }
                else {
                    i += 1;
                    j -= 1;
                }
            }
        }
        return res;
    }
}