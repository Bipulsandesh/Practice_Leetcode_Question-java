class Solution {
    int res = Integer.MAX_VALUE;
    int total;
    int[] val;
    List<Integer>[] adj;

    public int dfs2(int x, int par, int ans1, int anc) {
        int xorr = val[x];
        for (int ch : adj[x]) {
            if (ch == par) continue;
            xorr ^= dfs2(ch, x, ans1, anc);
        }
        if (par == anc) return xorr;

        int a = ans1, b = xorr, c = total ^ ans1 ^ xorr;
        int maxVal = Math.max(a, Math.max(b, c));
        int minVal = Math.min(a, Math.min(b, c));
        res = Math.min(res, maxVal - minVal);

        return xorr;
    }

    public int dfs(int x, int par) {
        int xorr = val[x];
        for (int ch : adj[x]) {
            if (ch == par) continue;
            xorr ^= dfs(ch, x);
        }

        for (int ch : adj[x]) {
            if (ch == par) {
                dfs2(ch, x, xorr, x);
            }
        }

        return xorr;
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        val = nums;
        adj = new ArrayList[n];
        total = 0;
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            total ^= nums[i];
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, -1);
        return res;
    }
}