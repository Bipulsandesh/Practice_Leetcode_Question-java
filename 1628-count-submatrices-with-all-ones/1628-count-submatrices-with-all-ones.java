class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;

        for( int startRow = 0; startRow < m; startRow++ ) {

            int[] arr = new int[n];
            Arrays.fill( arr, 1 );
            for( int endRow = startRow; endRow < m; endRow++ ) {

                for( int col = 0; col < n; col++ ) {
                     arr[col] = arr[col] & mat[endRow][col];
                }

                result += arrayCount(arr);

            }

        }

        return result;

    }

    private int arrayCount( int[] arr ) {
        int streak = 0;
        int count = 0;

        for( int temp : arr ) {
            if(temp == 0) {
                streak = 0;
            }
            else{
                streak += 1;
            }
            count += streak;
        } 
        return count;
    }

}