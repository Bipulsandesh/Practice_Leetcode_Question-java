class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int i = 0;
        int j = 0;
        int maxi = 0;

        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.get(nums[j]) > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);
            j++;
        }

        return maxi;
    }
}