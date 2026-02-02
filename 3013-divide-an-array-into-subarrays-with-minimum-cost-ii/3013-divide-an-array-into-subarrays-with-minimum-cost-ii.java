class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>(); // k-1 smallest
    TreeMap<Integer, Integer> large = new TreeMap<>();
    
    long sum = 0;
    int smallCnt = 0;
    int k;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        this.k = k - 1;      
        int w = dist + 1;

        long ans = Long.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            add(nums[i]);

            if (i > w) {
                remove(nums[i - w]);
            }

            rebalance();

            if (i >= w) {
                ans = Math.min(ans, sum);
            }
        }

        return nums[0] + (ans == Long.MAX_VALUE ? 0 : ans);
    }

    private void add(int x) {
        if (smallCnt < k || x <= small.lastKey()) {
            small.put(x, small.getOrDefault(x, 0) + 1);
            sum += x;
            smallCnt++;
        } else {
            large.put(x, large.getOrDefault(x, 0) + 1);
        }
    }

    private void remove(int x) {
        if (small.containsKey(x)) {
            dec(small, x);
            sum -= x;
            smallCnt--;
        } else {
            dec(large, x);
        }
    }

    private void rebalance() {
        while (smallCnt > k) {
            int x = small.lastKey();
            dec(small, x);
            sum -= x;
            smallCnt--;
            large.put(x, large.getOrDefault(x, 0) + 1);
        }

        while (smallCnt < k && !large.isEmpty()) {
            int x = large.firstKey();
            dec(large, x);
            small.put(x, small.getOrDefault(x, 0) + 1);
            sum += x;
            smallCnt++;
        }
    }

    private void dec(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
    }
}