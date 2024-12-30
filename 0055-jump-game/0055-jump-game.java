class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = n-1;

        for(int idx=n-2; idx>=0; idx--){
            if(idx + nums[idx] >= farthest){
                farthest = idx;
            }
        }
        return farthest == 0;
    }
}