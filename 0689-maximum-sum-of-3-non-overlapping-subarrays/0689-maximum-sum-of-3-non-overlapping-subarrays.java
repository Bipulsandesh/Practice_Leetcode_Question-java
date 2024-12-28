class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[3];

        // Calculate left max indices
        int maxLeftIndex = 0;
        for (int i = k - 1; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > sum[maxLeftIndex + k] - sum[maxLeftIndex]) {
                maxLeftIndex = i + 1 - k;
            }
            left[i] = maxLeftIndex;
        }

        // Calculate right max indices
        int maxRightIndex = n - k;
        for (int i = n - k; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= sum[maxRightIndex + k] - sum[maxRightIndex]) {
                maxRightIndex = i;
            }
            right[i] = maxRightIndex;
        }

        // Find the three intervals with max sum
        int maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int totalSum = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }
}
