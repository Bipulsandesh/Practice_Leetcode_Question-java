class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] paths = new ArrayList[n];
        for(int i = 0; i < n; i++){
            paths[i] = new ArrayList<>();
        }
        
        for(int[] x: edges){
            int u = x[0], v = x[1], w = x[2];
            paths[u].add(new int[]{v, w});
            paths[v].add(new int[]{u, w * 2});
        }

        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];

            if(w > weight[u]){
                continue;
            }

            for(int[] x: paths[u]){
                int v = x[0], t = x[1];
                if(weight[v] > w + t){
                    weight[v] = w + t;
                    pq.add(new int[]{v, weight[v]});
                }
            }
        }

        return weight[n - 1] == Integer.MAX_VALUE ? -1 : weight[n - 1];
    }
}