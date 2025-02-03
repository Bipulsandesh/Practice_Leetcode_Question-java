public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        
        increasing[0] = 1;
        decreasing[0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing[i] = increasing[i - 1] + 1;
                decreasing[i] = 1;
            } else if (nums[i] < nums[i - 1]) {
                decreasing[i] = decreasing[i - 1] + 1;
                increasing[i] = 1;
            } else {
                increasing[i] = 1;
                decreasing[i] = 1;
            }
        }
        
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, Math.max(increasing[i], decreasing[i]));
        }
        
        return maxLength;
    }
}

