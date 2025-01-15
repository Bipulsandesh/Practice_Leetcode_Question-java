class Solution {
    // Depth First Search (DFS) to traverse and mark connected 'O' cells
    public void dfs(char[][] board, int r, int c, boolean[][] vis) {
        // Base case: if out of bounds, or current cell is 'X', return
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 'X') {
            return;
        }

        // Explore the upward cell if it is 'O' and not visited
        if (r > 0 && board[r - 1][c] == 'O' && !vis[r - 1][c]) {
            vis[r - 1][c] = true;
            dfs(board, r - 1, c, vis);
        }

        // Explore the downward cell if it is 'O' and not visited
        if (r < board.length - 1 && board[r + 1][c] == 'O' && !vis[r + 1][c]) {
            vis[r + 1][c] = true;
            dfs(board, r + 1, c, vis);
        }

        // Explore the leftward cell if it is 'O' and not visited
        if (c > 0 && board[r][c - 1] == 'O' && !vis[r][c - 1]) {
            vis[r][c - 1] = true;
            dfs(board, r, c - 1, vis);
        }

        // Explore the rightward cell if it is 'O' and not visited
        if (c < board[0].length - 1 && board[r][c + 1] == 'O' && !vis[r][c + 1]) {
            vis[r][c + 1] = true;
            dfs(board, r, c + 1, vis);
        }
    }

    public void solve(char[][] board) {
        // Edge case: if the board is empty, no operation is needed
        if (board.length == 0) return;

        // Create a visited array to track cells connected to the boundary
        boolean vis[][] = new boolean[board.length][board[0].length];

        // Mark and perform DFS for the first row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                vis[0][i] = true;
                dfs(board, 0, i, vis);
            }
        }

        // Mark and perform DFS for the last row
        for (int i = board[0].length - 1; i >= 0; i--) {
            if (board[board.length - 1][i] == 'O' && !vis[board.length - 1][i]) {
                vis[board.length - 1][i] = true;
                dfs(board, board.length - 1, i, vis);
            }
        }

        // Mark and perform DFS for the first column (excluding corners)
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                vis[i][0] = true;
                dfs(board, i, 0, vis);
            }
        }

        // Mark and perform DFS for the last column (excluding corners)
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][board[0].length - 1] == 'O' && !vis[i][board[0].length - 1]) {
                vis[i][board[0].length - 1] = true;
                dfs(board, i, board[0].length - 1, vis);
            }
        }

        // Update the board based on visited array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If a cell is not visited, it is surrounded by 'X', so flip it to 'X'
                if (!vis[i][j]) {
                    board[i][j] = 'X';
                } else {
                    // Otherwise, keep it as 'O'
                    board[i][j] = 'O';
                }
            }
        }
    }
}