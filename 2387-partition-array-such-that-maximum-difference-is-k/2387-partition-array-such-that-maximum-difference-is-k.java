class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int start=0;
        int count=0;
        while(start<nums.length)
        {
            int min=nums[start];
            while(start<nums.length&&nums[start]-min<=k)
            {
                start++;
            }          
            count++;
        }
        return count;
    }
}