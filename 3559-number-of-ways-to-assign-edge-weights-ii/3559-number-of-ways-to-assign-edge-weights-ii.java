class Solution {
    static final int MOD = 1_000_000_007;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] depth = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    depth[nei] = depth[node] + 1;
                    parent[nei] = node;
                    q.offer(nei);
                }
            }
        }
        int LOG = 1;

        while ((1 << LOG) <= n) LOG++;
        int[][] up = new int[LOG][n + 1];
        up[0] = parent.clone();
        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v <= n; v++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }
        }

        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (int)((long)pow2[i - 1] * 2 % MOD);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int ancestor = lca(u, v, up, depth, LOG);
            int dist = depth[u] + depth[v] - 2 * depth[ancestor];
            ans[i] = dist == 0 ? 0 : pow2[dist - 1];
        }
        return ans;
    }

    private int lca(int u, int v, int[][] up, int[] depth, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) == 1) {
                u = up[k][u];
            }
        }
        if (u == v) 
            return u;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }
        return up[0][u];
    }
}