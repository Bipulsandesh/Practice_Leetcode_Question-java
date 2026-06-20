import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        List<int[]> list = new ArrayList<>();

        // Building 1 always has height 0
        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        // Add building n with maximum possible height n-1
        list.add(new int[]{n, n - 1});

        list.sort((a, b) -> a[0] - b[0]);

        int size = list.size();

        // Left to right
        for (int i = 1; i < size; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(list.get(i)[1],
                                      list.get(i - 1)[1] + dist);
        }

        // Right to left
        for (int i = size - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(list.get(i)[1],
                                      list.get(i + 1)[1] + dist);
        }

        long ans = 0;

        // Find maximum peak between consecutive restrictions
        for (int i = 1; i < size; i++) {
            int x1 = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];
            int x2 = list.get(i)[0];
            int h2 = list.get(i)[1];

            int dist = x2 - x1;
            long peak = (long)(h1 + h2 + dist) / 2;

            ans = Math.max(ans, peak);
        }

        return (int) ans;
    }
}