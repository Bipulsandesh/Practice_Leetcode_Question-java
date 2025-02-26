class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int maxSoFar = 0, minSoFar = 0;

        for (int num : nums) {
            maxSum = Math.max(0, maxSum + num);
            minSum = Math.min(0, minSum + num);

            maxSoFar = Math.max(maxSoFar, maxSum);
            minSoFar = Math.min(minSoFar, minSum);
        }

        return Math.max(maxSoFar, Math.abs(minSoFar));
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4})); // Output: 5
        System.out.println(sol.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})); // Output: 8
    }
}
