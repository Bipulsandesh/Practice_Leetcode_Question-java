class Solution
{
    public long maxSubarraySum(int[] nums, int k)
    {
        int n = nums.length;

        // Step 1: Create prefix sum array
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++)
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Step 2: Initialize array to track minimum prefix sums for each remainder
        long[] minPrefixSum = new long[k];
        for (int i = 0; i < k; i++)
        {
            minPrefixSum[i] = Long.MAX_VALUE; // Initialize with maximum value
        }

        // Step 3: Initialize maxSum to track the result
        long maxSum = Long.MIN_VALUE; // Initialize result as the smallest value

        // Step 4: Iterate over the prefix sum array
        for (int i = 0; i <= n; i++)
        {
            int remainder = i % k;

            // Step 5: If i >= k, calculate the maximum subarray sum
            if (i >= k)
            {
                maxSum = Math.max(maxSum, prefixSum[i] - minPrefixSum[remainder]);
            }

            // Step 6: Update the minimum prefix sum for the current remainder
            minPrefixSum[remainder] = Math.min(minPrefixSum[remainder], prefixSum[i]);
        }

        // Step 7: Return the result (0 if no valid subarray is found)
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}