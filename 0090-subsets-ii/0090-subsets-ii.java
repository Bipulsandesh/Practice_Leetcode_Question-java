class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting helps to handle duplicates
        
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            tempList.add(nums[i]); // Include current number in subset
            backtrack(result, tempList, nums, i + 1); // Move forward in the array
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }
}