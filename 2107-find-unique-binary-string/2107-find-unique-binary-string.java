class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            // Flip the ith bit of the ith string
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        
        return result.toString();
    }

    // Testing the function
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findDifferentBinaryString(new String[]{"01", "10"})); // Output: "11" or "00"
        System.out.println(sol.findDifferentBinaryString(new String[]{"00", "01"})); // Output: "11" or "10"
        System.out.println(sol.findDifferentBinaryString(new String[]{"111", "011", "001"})); // Output: "101" or any missing binary string
    }
}

