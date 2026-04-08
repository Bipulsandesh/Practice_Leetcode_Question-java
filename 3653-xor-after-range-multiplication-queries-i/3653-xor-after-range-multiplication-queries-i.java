class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int mod=1_000_000_007;
        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            int v=q[3];
            int k=q[2];
            while(l<=r){
                nums[l]=(int)(((long)nums[l]*v)%mod);
                l+=k;
            }
            // System.out.println(Arrays.toString(nums));
        }
        int xor=0;
        for(int l:nums) xor=xor^l;
        return xor;
    }
}