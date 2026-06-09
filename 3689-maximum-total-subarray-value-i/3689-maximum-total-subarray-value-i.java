class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mn = nums[0];
        long mx = nums[0];

        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }

        long best = mx - mn;

        return best * k;
    }
}