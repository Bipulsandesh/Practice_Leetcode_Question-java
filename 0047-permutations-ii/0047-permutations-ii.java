class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Create a list to store the final results
        List<List<Integer>> res = new ArrayList<>();
        // Sort the input array to group duplicates together
        Arrays.sort(nums);
        // Create a boolean array to keep track of used numbers
        boolean[] used = new boolean[nums.length];
        // Call the recursive backtrack method to generate all permutations
        backtrack(nums, used, new ArrayList<>(), res);
        // Return the list of permutations
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        // If the current permutation is complete, add it to the results list
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        // Loop through the indices of the input array
        for (int i = 0; i < nums.length; i++) {
            // Skip if the number has already been used or if it's a duplicate that has already been used
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            // Mark the current number as used, add it to the current permutation list
            used[i] = true;
            curr.add(nums[i]);
            // Recursively call backtrack to generate all permutations
            backtrack(nums, used, curr, res);
            // Mark the current number as unused, remove it from the current permutation list
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}