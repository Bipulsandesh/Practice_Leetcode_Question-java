class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length, left = 0, right = 0, ans = 0, space[] = new int[n + 1], mr[] = new int[n + 1];
        for (int i = 0; i < startTime.length; i++) {
            space[i] = startTime[i] - right;
            right = endTime[i];
        }
        space[n] = eventTime - right;
        for (int i = n - 1; i >= 0; i--)
            mr[i] = Math.max(mr[i + 1], space[i + 1]);
        for (int i = 1; i <= n; i++) {
            int dur = endTime[i - 1] - startTime[i - 1];
            if (left >= dur || mr[i] >= dur)
                ans = Math.max(ans, space[i - 1] + dur + space[i]);
            ans = Math.max(ans, space[i - 1] + space[i]);
            left = Math.max(left, space[i - 1]);
        }
        return ans;
    }
}