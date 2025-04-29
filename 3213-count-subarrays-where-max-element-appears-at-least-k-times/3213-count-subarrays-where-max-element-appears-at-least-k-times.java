class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int left = 0;
        int a = 0;
        for(int right = 0; right < n; right++) {
            if(nums[right] == max) a++;
            while(a >= k) {
                count += (n - right);
                if(nums[left] == max) a--;
                left++;
            }
        }
        return count;
    }
}