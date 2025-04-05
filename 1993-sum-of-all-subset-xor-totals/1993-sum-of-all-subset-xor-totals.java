class Solution {
    int sum = 0;         // To store the total sum of XORs of all subsets
    int[] nums;          // Input array reference

    // Main function to calculate the XOR sum of all subsets
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        sol(0, 0);       // Start recursive exploration from index 0 with XOR = 0
        return sum;
    }

    // Recursive function to explore all subsets
    private void sol(int idx, int xt){
        // Base case: if we've considered all elements
        if(idx == nums.length){
            sum += xt;   // Add the XOR value of this subset to the total sum
            return;
        }

        // Choice 1: include nums[idx] in the current subset
        sol(idx + 1, xt ^ nums[idx]);

        // Choice 2: exclude nums[idx] from the current subset
        sol(idx + 1, xt);
    }
}