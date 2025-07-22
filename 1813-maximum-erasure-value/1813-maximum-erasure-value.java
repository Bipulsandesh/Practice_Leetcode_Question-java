class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max_sum = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end<nums.length){
            sum = sum + nums[end];
            while(set.contains(nums[end])){
                sum = sum - nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(nums[end]);
            max_sum = Math.max(sum,max_sum);
            end++;
        }
        return max_sum;
    }
}