class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] freq = new int[2 * n + 1];
        freq[n] = 1;
        int idx = n;
        long res = 0;
        long pref = 0;
        for (int x : nums) {
            if (x == target) {
                pref += freq[idx];
                idx++;
            } else {
                idx--;
                pref -= freq[idx];
            }
            freq[idx]++;
            res += pref;
        }
        return res;
    }
}