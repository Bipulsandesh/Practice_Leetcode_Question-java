class Solution {
    public class Group implements Comparable<Group> {
        int val;
        int row;
        int col;

        Group(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Group o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public int swimInWater(int[][] grid) {
        PriorityQueue<Group> pq = new PriorityQueue<>();
        int m = grid.length;
        int n = grid.length;
        pq.offer(new Group(grid[0][0], 0, 0));
        int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int ans = grid[0][0];
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            Group curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            ans = Math.max(curr.val, ans);
            if (r == m - 1 && c == n - 1) {
                return ans;
            }

            for (int d[] : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < m && nr >= 0 && nc < n && nc >= 0 && !vis[nr][nc]) {
                    pq.offer(new Group(grid[nr][nc], nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return ans;
    }
}