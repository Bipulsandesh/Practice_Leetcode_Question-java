class Solution {
    public int countHillValley(int[] nums) {
        int prev_idx = 0;
        int next_idx = 0;
        int count = 0;

        // loop from [1, len(nums)-2] (inclusive)
        int i=1;
        while (i < nums.length-1) {
            // skip if same current numbers
            if (nums[i] == nums[i+1]){
                i++;
                continue;
            }

            // find next index to compare
            int j=i+1;
            while (j < nums.length-1 && nums[j] == nums[j+1]) { // skip if duplicate numbers next
                j++;
            }
            next_idx = j;
            
            if (nums[i] > nums[prev_idx] && nums[i] > nums[next_idx]) { // hill
                count++;
            } else if (nums[i] < nums[prev_idx] && nums[i] < nums[next_idx]) { // valley
                count++;
            }

            prev_idx = i; // update prev value
            i = j;
        }
        return count;
    }
}