class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);  
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                answer = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return answer;
    }
     private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; 
            }
        }
        return count >= p;
    }

}