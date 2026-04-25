import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] dist = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) dist[i] = x;
            else if (x == side) dist[i] = side + y;
            else if (y == side) dist[i] = 3L * side - x;
            else dist[i] = 4L * side - y;
        }
        
        Arrays.sort(dist);
        long perimeter = 4L * side;
        int low = 1, high = side;
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, dist, k, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean check(int d, long[] dist, int k, long perimeter) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            long last = dist[i];
            int curr = i;
            for (int j = 1; j < k; j++) {
                int next = lowerBound(dist, last + d);
                if (next >= n) {
                    count = -1;
                    break;
                }
                last = dist[next];
                count++;
            }
            if (count == k && dist[i] + perimeter - last >= d) {
                return true;
            }
            if (dist[i] > dist[0] + d) break;
        }
        return false;
    }
    
    private int lowerBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}