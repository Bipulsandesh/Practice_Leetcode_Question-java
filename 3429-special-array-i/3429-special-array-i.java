class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;  // Correctly use nums.length to get the size of the array.
        
        // Loop through the array to check alternating even and odd values.
        for (int i = 0; i < n - 1; i++) {
            boolean flag = nums[i] % 2 == 0;   // True if even
            boolean flag1 = nums[i + 1] % 2 == 0;  // True if next number is even

            // Check if both are either even or odd (i.e., same parity).
            if (flag == flag1) {
                return false;  // If both are even or both are odd, return false.
            }
        }
        
        return true;  // If we never find two consecutive numbers with the same parity, return true.
    }
}
