class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
        return;
    }
    private static boolean helper(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }
        int nextRow = row; 
        int nextCol = col + 1;
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        if(board[row][col] != '.'){
            return helper(board, nextRow, nextCol);
        }
        for(int dig = 1; dig <= 9; dig++){
            if(isSafe(board, row, col, dig)){
                board[row][col] = (char)(dig + '0');
                if(helper(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    private static boolean isSafe(char[][] board, int row, int col, int dig){
        for(int i = 0; i<9; i++){
            if(board[row][i] == (char)(dig + '0')){
                return false;
            }
        }
        for(int i = 0; i<9; i++){
            if(board[i][col] == (char)(dig + '0')){
                return false;
            }
        }
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for(int i = sr; i <= sr+2; i++){
            for(int j = sc; j <= sc+2; j++){
                if(board[i][j] == (char)(dig + '0')){
                    return false;
                }
            }
        }
        return true;
    }
}