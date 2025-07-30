class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = 0;
        for(int num : nums){
            maxi = Math.max(num, maxi);
        }

        int len = 0;
        int maxLen = 0;
        for(int num: nums){
            if(num == maxi){
                len++;
            }else{
                maxLen = Math.max(maxLen, len);
                len = 0;
            }
        }
        maxLen = Math.max(maxLen, len);

        return maxLen;
    }
}