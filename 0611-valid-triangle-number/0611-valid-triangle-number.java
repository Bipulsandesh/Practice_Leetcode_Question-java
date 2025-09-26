class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int a=2;a<nums.length;a++) {
            int b=0,c=a-1;
            while(b<c) {
                if(nums[b] + nums[c] > nums[a]) {
                    ans += c-b;
                    c--;
                } else {
                    b++;
                }
            }
        }
        return ans;
    }
}