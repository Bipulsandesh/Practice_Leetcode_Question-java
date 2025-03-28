class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length, qLen = queries.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Store original indices and sort queries
        int[][] qIndex = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            qIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qIndex, Comparator.comparingInt(a -> a[0]));
        
        // Min-heap (PriorityQueue) to store (value, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        
        int[] result = new int[qLen];
        int count = 0;
        
        for (int[] q : qIndex) {
            int query = q[0], index = q[1];

            // Process the heap while top element is less than the query value
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] cell = pq.poll();
                int r = cell[1], c = cell[2];
                count++;

                // Explore neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            result[index] = count;
        }
        
        return result;
    }
}