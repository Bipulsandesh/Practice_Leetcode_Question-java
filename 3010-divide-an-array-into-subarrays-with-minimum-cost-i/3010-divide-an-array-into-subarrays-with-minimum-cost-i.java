class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];

        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < num1) {
                num2 = num1;
                num1 = nums[i];
            } else if (nums[i] < num2) {
                num2 = nums[i];
            }
        }

        return first + num1 + num2;
    }
}