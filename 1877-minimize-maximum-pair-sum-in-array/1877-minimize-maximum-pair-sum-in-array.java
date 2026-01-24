class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxSum = 0;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            left++;
            right--;
        }
        return maxSum;
    }
}