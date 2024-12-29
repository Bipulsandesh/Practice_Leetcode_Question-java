class Solution {
    int n;
    int sqrt;
    int[] rows;
    int[] cols;
    int[] box;
    char[][] board;

    private boolean isPerfectSquare(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt*sqrt ==n;
    }
    private void initialize(char[][] board){
        this.n = board.length;
        this.sqrt = (int) Math.sqrt(n);
        if(n != board[0].length){
            throw new IllegalArgumentException("board must be a nxn");
        }
        if(!isPerfectSquare(n)){
            throw new IllegalArgumentException("board size should be perfect square");
        }
        rows = new int[n];
        cols = new int[n];
        box = new int[n];
        this.board = board;
    }

    private void updateInitialState(){
        for(int i=0;  i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    int val = board[i][j] - '0';
                    tryStoring(val, i, j);
                }
            }
        }
    }


    public void solveSudoku(char[][] board) {
        initialize(board);
        updateInitialState();
        traverse(0, 0);
    }

    private boolean tryStoring(int val, int r, int c){
        int valBitPos = 1<<(val-1);
        int k = (r/sqrt)*(sqrt) + c/sqrt; //box id or index
        if( (rows[r] & valBitPos) > 0 ||
            (cols[c] & valBitPos) > 0 || 
            (box[k] & valBitPos) > 0){
                return false;
            }

            rows[r] |= valBitPos;
            cols[c] |= valBitPos;
            box[k]  |= valBitPos;
            board[r][c] = Character.forDigit(val, 10);
            return true;
    }

    private void unStore(int val, int r, int c){
        board[r][c] = '.';
        int k = (r/sqrt)*sqrt + c/sqrt;
        int valBitPos = 1<<(val-1);
        rows[r] &= ~valBitPos;
        cols[c] &= ~valBitPos;
        box[k] &= ~valBitPos;
    }

    private boolean moveNext(int r, int c){
        if(r==n-1 && c==n-1) {
            return true;
        }
        if(c==n-1){
            return traverse(r+1,0);
        }
        else{
            return traverse(r,c+1);
        }
    }

    public boolean traverse(int r, int c){
        if(board[r][c] != '.'){
            return moveNext(r,c);
        }
        
        for(int v=1;v<=n;v++){
            if(tryStoring(v,r,c)){
                if(moveNext(r,c)){
                    return true;
                }
                unStore(v,r,c);
            }
                
        }
        return false;
    }
}