class Solution {
    public int countValidSelections(int[] nums) {
        int ans = 0;
        int sum = 0;

        for(int num : nums ){
            sum +=  num;
        }

        int leftsum = 0;

        for(int i=0; i<nums.length; i++) {
            leftsum += nums[i];

            if(nums[i]==0) {
                if(leftsum==(sum-leftsum)) {
                    ans += 2;
                }
                else if(Math.abs(leftsum-(sum-leftsum))==1) {
                    ans +=1;
                }
            }
        }
        return ans;
    }
}