class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int neighborIndex = (i + 1) % nums.length;

            int curr = Math.abs(nums[i] - nums[neighborIndex]);

            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
}