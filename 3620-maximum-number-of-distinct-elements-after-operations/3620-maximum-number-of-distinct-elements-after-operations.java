class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinct_elements=0, prev= Integer.MIN_VALUE;
        for(int num: nums){
            int cur= Math.min(Math.max(num-k, prev+1), num+k);
            if(cur>prev){
                distinct_elements+=1;
                prev= cur;
            }
        }
        return distinct_elements;
    }
}