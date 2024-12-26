class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        rec(0,0,nums,target);
        return count;
    }
    void rec(int i,int curSum,int[] nums,int target){
        if(i==nums.length){
            if(curSum==target){
                count++;
            }
            return;
        }
        int a=nums[i];
        i++;
        rec(i,curSum+a,nums,target);
        rec(i,curSum-a,nums,target);

    }
}