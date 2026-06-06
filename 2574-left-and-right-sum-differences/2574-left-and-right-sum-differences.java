class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefix = 0;
        int suffix = 0;
        for (int i : nums) {
            suffix += i;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            res[i] = Math.abs(prefix - suffix);
            suffix -= nums[i];
        }
        return res;
    }
}