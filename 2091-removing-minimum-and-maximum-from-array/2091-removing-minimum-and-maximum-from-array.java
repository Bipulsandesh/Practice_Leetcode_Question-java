class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int mn = 0;
        int mx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[mn])
                mn = i;

            if (nums[i] > nums[mx])
                mx = i;
        }

        int left = Math.min(mn, mx);
        int right = Math.max(mn, mx);

        return Math.min(
            right + 1,
            Math.min(
                n - left,
                left + 1 + n - right
            )
        );
    }
}