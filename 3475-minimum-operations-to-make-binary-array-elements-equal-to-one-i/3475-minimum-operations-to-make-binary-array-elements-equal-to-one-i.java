public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                // Flip the current, next, and next-next elements
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                operations++;
            }
        }

        // Check if the transformation is successful
        for (int num : nums) {
            if (num == 0) return -1;
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {0, 1, 1, 1, 0, 0};
        System.out.println(sol.minOperations(nums1)); // Output: 3

        int[] nums2 = {0, 1, 1, 1};
        System.out.println(sol.minOperations(nums2)); // Output: -1
    }
}
