class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        result = Math.min(result,Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                        found = true;
                    }
                }
            }
        }
        if(found){
            return result;
        }
        return -1;
    }
}