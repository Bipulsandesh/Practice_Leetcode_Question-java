class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int [] arr =new int[nums.length];
        arr[0]=1;
        for(int i=1;i<nums.length;i++){
            arr[i] = (arr[i-1]*2)%mod;
        }

        int i = 0;
        int j = nums.length-1;
        int count = 0;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count+=arr[j-i];
                count%=mod;
                i++;
            }
            else
                j--;
        }
        return count;
    }
}