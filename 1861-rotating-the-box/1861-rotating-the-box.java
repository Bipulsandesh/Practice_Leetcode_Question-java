class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] dup = new char[n][m];
        

        for(int i=0;i<m;i++){
            int empty = n-1;
            for(int j=n-1;j>=0;j--){
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    boxGrid[i][empty]='#';
                    empty--;
                }else if(boxGrid[i][j]=='*'){
                    empty = j-1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dup[i][j] = boxGrid[m - 1 - j][i];
            }
        }
        return dup;
    }
}