
import java.util.*;

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int low = 0, high = 0;
        for (int[] e : edges) high = Math.max(high, e[2] * 2);

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormMST(n, edges, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean canFormMST(int n, int[][] edges, int k, int minStability) {
        DSU dsu = new DSU(n);
        int edgesCount = 0;
        int upgradesUsed = 0;

        List<int[]> optionalNoUpgrade = new ArrayList<>();
        List<int[]> optionalNeedsUpgrade = new ArrayList<>();

        // 1. Process Mandatory Edges
        for (int[] e : edges) {
            if (e[3] == 1) { // musti == 1
                if (e[2] < minStability) return false; // Mandatory edge too weak
                if (!dsu.union(e[0], e[1])) return false; // Cycle formed by mandatory edges
                edgesCount++;
            } else {
                if (e[2] >= minStability) {
                    optionalNoUpgrade.add(e);
                } else if (e[2] * 2 >= minStability) {
                    optionalNeedsUpgrade.add(e);
                }
            }
        }

        // 2. Add Optional Edges (No Upgrade needed)
        for (int[] e : optionalNoUpgrade) {
            if (dsu.union(e[0], e[1])) {
                edgesCount++;
            }
        }

        // 3. Add Optional Edges (Upgrade needed)
        for (int[] e : optionalNeedsUpgrade) {
            if (upgradesUsed < k && dsu.union(e[0], e[1])) {
                upgradesUsed++;
                edgesCount++;
            }
        }

        // Must have exactly n-1 edges and all nodes connected
        return edgesCount == n - 1;
    }

    class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }
}