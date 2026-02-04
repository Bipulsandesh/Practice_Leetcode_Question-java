class Solution {
    public long maxSumTrionic(int[] nums) {
        int state = 0;
        long sum = 0;
        long max =  Long.MIN_VALUE;
        long contSum = 0;

        for (int i = 1; i < nums.length; i++){
            if (state == 0){
                if (nums[i] > nums[i-1]){
                    sum = sum + nums[i] + nums[i-1];
                    state = 1;
                }
            }
            else if (state == 1){
                if (nums[i] > nums[i-1]){
                    sum =Math.max(sum + nums[i], nums[i] + nums[i-1]);
                }
                else if (nums[i] == nums[i-1]){
                    sum = 0;
                    state = 0;
                }
                else {
                    sum = sum + nums[i];
                    state = 2;
                }
            }
            else if (state == 2){
                contSum = 0;
                if (nums[i] < nums[i-1]){
                    sum = sum + nums[i];
                }
                else if (nums[i] == nums[i-1]){
                    sum = 0;
                    state = 0;
                }
                else {
                    sum = sum + nums[i];
                    max = Math.max(max,sum);
                    contSum = contSum + nums[i] + nums[i-1];
                    state = 3;
                }
            }
            else {
                if (nums[i] > nums[i-1]){
                    sum = sum + nums[i];
                    contSum = Math.max(contSum + nums[i],nums[i] + nums[i-1]);
                    max = Math.max(max,sum);
                }
                else if (nums[i] == nums[i-1]){
                    sum = 0;
                    state = 0;
                }
                else {
                    sum = contSum + nums[i];
                    state = 2;
                }
            }

        }
        return max;
    }
}