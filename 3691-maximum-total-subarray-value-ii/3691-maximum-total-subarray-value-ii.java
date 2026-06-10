import java.util.*;

class Solution {

    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] maxSt;
    int[][] minSt;
    int[] log;

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int k = log[len];

        int mx = Math.max(
            maxSt[k][l],
            maxSt[k][r - (1 << k) + 1]
        );

        int mn = Math.min(
            minSt[k][l],
            minSt[k][r - (1 << k) + 1]
        );

        return (long) mx - mn;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int m = log[n] + 1;

        maxSt = new int[m][n];
        minSt = new int[m][n];

        for (int i = 0; i < n; i++) {
            maxSt[0][i] = nums[i];
            minSt[0][i] = nums[i];
        }

        for (int j = 1; j < m; j++) {
            int len = 1 << j;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                maxSt[j][i] = Math.max(
                    maxSt[j - 1][i],
                    maxSt[j - 1][i + half]
                );

                minSt[j][i] = Math.min(
                    minSt[j - 1][i],
                    minSt[j - 1][i + half]
                );
            }
        }

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(
                    getValue(cur.l, nr),
                    cur.l,
                    nr
                ));
            }
        }

        return ans;
    }
}