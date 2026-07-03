class Pair {
    int v;
    long w;

    Pair(int v, long w) {
        this.v = v;
        this.w = w;
    }
}

class State {
    int node;
    long cost;

    State(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    private static final long INF = Long.MAX_VALUE / 4;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        // total cost < k for the paths 
        // score = min edge cost along the path 
        int n = online.length;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        long mnCostValue = INF;
        long mxCostValue = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            long c = e[2];

            adj.get(u).add(new Pair(v, c));

            mnCostValue = Math.min(mnCostValue, c);
            mxCostValue = Math.max(mxCostValue, c);
        }

        // return teh maximum path score out of all paths. 
        // use a binary search on possible path costs 
        // and check if we only traverse nodes iwth edge value less than that node, and if there exists a path will scroe <= k 
        long lo = mnCostValue, hi = mxCostValue;
        int ans = -1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (isValid(adj, k, online, mid)) {
                ans = (int) mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(List<List<Pair>> adj, long k, boolean[] online, long mid) {
        // we can use Dijkstra's algo here. 
        int n = online.length;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        pq.offer(new State(0, 0L));
        dist[0] = 0L;

        while (pq.size() > 0) {
            State top = pq.remove();
            int node = top.node;
            long pathCost = top.cost;

            if (pathCost != dist[node]) continue;

            if (node == n - 1) return true;

            for (Pair a : adj.get(node)) {
                int nx = a.v;
                long cost = a.w;

                if (!online[nx]) continue;
                if (cost < mid) continue;

                long newCost = pathCost + cost;

                if (newCost < dist[nx] && newCost <= k) {
                    dist[nx] = newCost;
                    pq.offer(new State(nx, newCost));
                }
            }
        }

        return false;
    }
}