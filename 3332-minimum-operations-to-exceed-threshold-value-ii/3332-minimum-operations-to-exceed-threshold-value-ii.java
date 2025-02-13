class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0;
        for (int x : nums) {
            if (x < k)
                pq.offer((long) x);
        }

        while (pq.size()>1 && pq.peek()<k) {
            long s1 = pq.poll();
            long s2 = pq.poll();

            long val = s1 * 2 + s2;

            pq.offer(val);
            ans++;
        }
        if(pq.size()==1 && pq.peek()<k) ans++;
        return ans;
    }
}








