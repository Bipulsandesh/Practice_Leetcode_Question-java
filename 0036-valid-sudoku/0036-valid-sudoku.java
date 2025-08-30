class Solution {
    public boolean isValidSudoku(char[][] board) {
        //for rows
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        //for cols
        for(int j=0;j<9;j++){
            Set<Character> set=new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        // for box
        for(int sr=0;sr<9;sr+=3){
            int er=sr+2;
            for(int sc=0;sc<9;sc+=3){
                int ec=sc+2;
                if(!(isValid(board,sr,er,sc,ec))) return false;
            }
        }
        return true;
    }

    boolean isValid(char[][]board,int sr,int er,int sc,int ec){
        Set<Character> set=new HashSet<>();
        for(int i=sr;i<=er;i++){
            for(int j=sc;j<=ec;j++){
                if(board[i][j]=='.') continue;

                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
}