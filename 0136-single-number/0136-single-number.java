class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0; // Initialize XOR result to 0
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i]; // XOR each number
        }
        return ans; // Return the single number
    }
}