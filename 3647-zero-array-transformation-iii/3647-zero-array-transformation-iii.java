import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int qz = queries.length;

        List<List<Integer>> qEnd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            qEnd.add(new ArrayList<>());
        }

        for (int i = 0; i < qz; i++) {
            qEnd.get(queries[i][0]).add(queries[i][1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        int[] cntQ = new int[n + 1];
        int dec = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            dec += cntQ[i];

            for (int j : qEnd.get(i)) {
                pq.offer(j);
            }

            int k;
            while (x > dec && !pq.isEmpty() && (k = pq.peek()) >= i) {
                cntQ[k + 1]--;
                pq.poll();
                dec++;
            }

            if (x > dec) return -1;
        }

        return pq.size();
    }
}