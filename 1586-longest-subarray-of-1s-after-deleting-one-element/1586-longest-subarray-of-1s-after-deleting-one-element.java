class Solution {
    public int longestSubarray(int[] nums) {
        int count1 = 0, count0 = 0, ans = 0;
        int left = 0, first_0_idx = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1 && count0 <= 1) {
                count1++;
            } else if (nums[right] == 0 && count0 == 0) {
                count0++;
                first_0_idx = right;
            } else if (nums[right] == 0 && count0 == 1) {
                count1 = right - first_0_idx - 1;
                count0 = 1;
                left = first_0_idx + 1;
                first_0_idx = right;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }
}