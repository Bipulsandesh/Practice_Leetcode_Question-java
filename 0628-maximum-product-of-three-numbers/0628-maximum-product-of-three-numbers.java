class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int nmax=nums[n-1]*nums[0]*nums[1];
        int pmax=nums[n-1]*nums[n-2]*nums[n-3];
        return Math.max(nmax, pmax);
    }
}