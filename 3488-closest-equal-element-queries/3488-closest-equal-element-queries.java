class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build map of value -> indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {
            int target = nums[q];
            List<Integer> list = map.get(target);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, q);

            int prev = (pos - 1 + list.size()) % list.size();
            int next = (pos + 1) % list.size();

            int prevIdx = list.get(prev);
            int nextIdx = list.get(next);

            int d1 = Math.abs(q - prevIdx);
            int d2 = Math.abs(q - nextIdx);

            int ans = Math.min(Math.min(d1, n - d1),
                               Math.min(d2, n - d2));

            result.add(ans);
        }

        return result;
    }
}