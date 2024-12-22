class Solution {
    public int[] leftmostBuildingQueries(int[] h, int[][] queries) {
        int n = queries.length;
        // Process and sort queries based on end position (descending)
        int q[][] = processQueries(queries, h);
        int res[] = new int[n];
        int ind = 0;
        // Stack to maintain potential meeting points (monotonic decreasing)
        Stack<Integer> st = new Stack<>();
        // Maps to optimize repeated queries from same start position
        HashMap<Integer, Integer> map1 = new HashMap<>(); // Stores search limit for each start position
        HashMap<Integer, Integer> map2 = new HashMap<>(); // Caches previous results for each start position

        // Process buildings from right to left
        for (int i = h.length - 1; i >= 0; i--) {
            // Remove buildings shorter than current
            while (!st.isEmpty() && h[st.peek()] <= h[i])
                st.pop();

            // Temporary stack to restore removed elements
            Stack<Integer> temp = new Stack<>();
            // Process all queries ending at current position i
            while (ind < n && q[ind][1] == i) {
                int val = h[q[ind][0]]; // Height of start building

                // Case 1: Same building query
                if (q[ind][0] == q[ind][1]) {
                    res[q[ind][3]] = q[ind][0];
                }
                // Case 2: Can directly move to end building
                else if (val < h[q[ind][1]]) {
                    res[q[ind][3]] = q[ind][1];
                }
                // Case 3: Need to find meeting point
                else {

                    // Get search limit, prev result for the current start
                    int limit = map1.getOrDefault(q[ind][0],h.length);
                    int r = map2.getOrDefault(q[ind][0], -1);
                    
                    // Remove buildings that are too low and not been processed i.e. less than limit
                    while (!st.isEmpty() && h[st.peek()] <= val && st.peek() < limit) {
                        temp.push(st.pop());
                    }
                    // Found valid meeting point
                    if ((!st.isEmpty() && h[st.peek()] > val)) {
                        res[q[ind][3]] = st.peek();
                    }
                    // No valid meeting point found, use the cached result
                    else
                        res[q[ind][3]] = r;
                    map2.put(q[ind][0], res[q[ind][3]]);
                }
                map1.put(q[ind][0], q[ind][1]);
                ind++;
            }

            // Restore stack state
            while (!temp.isEmpty())
                st.push(temp.pop());

            if (ind == n)
                return res;

            st.push(i);
        }
        return res;
    }

    // Preprocess queries: normalize start/end positions and sort by end position
    int[][] processQueries(int queries[][], int h[]) {
        int n = queries.length;
        int q[][] = new int[n][4]; // [start,end,startHeight,originalIndex]
        for (int i = 0; i < n; i++) {
            q[i][0] = Math.min(queries[i][0], queries[i][1]); // Start position
            q[i][1] = Math.max(queries[i][0], queries[i][1]); // End position
            q[i][2] = h[q[i][0]]; // Height at start
            q[i][3] = i; // Original query index
        }
        // Sort by end position(descending), break ties by start height(ascending)
        Arrays.sort(q, (a, b) -> (a[1] != b[1]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[2], b[2]));
        return q;
    }
}