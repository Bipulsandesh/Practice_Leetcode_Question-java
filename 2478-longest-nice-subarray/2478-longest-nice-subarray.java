class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitwiseOr = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((bitwiseOr & nums[right]) != 0) {
                bitwiseOr ^= nums[left]; // Remove nums[left] from the window
                left++;
            }
            bitwiseOr |= nums[right]; // Add nums[right] to the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubarray(new int[]{1, 3, 8, 48, 10})); // Output: 3
        System.out.println(solution.longestNiceSubarray(new int[]{3, 1, 5, 11, 13})); // Output: 1
    }
}
