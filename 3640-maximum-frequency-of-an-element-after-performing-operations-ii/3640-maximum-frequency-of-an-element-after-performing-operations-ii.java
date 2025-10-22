class Solution {
    public int count(int x, int[] nums, int k, int numOperations, HashMap<Integer,Integer> map) {
        int left=-1,right=-1;
        int l=0,r=nums.length-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(nums[m] >= x-k) {
                left = m;
                r=m-1;
            } else
                l = m+1;
        }
        l=0;
        r=nums.length-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(nums[m] <= x+k) {
                right = m;
                l=m+1;
            } else
                r = m-1;
        }
        int total = right - left + 1;
        int freq = map.getOrDefault(x,0);
        int modifications = total - freq;
        return freq + Math.min(modifications, numOperations);
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for(int num : nums) {
            ans = Math.max(ans,count(num, nums, k, numOperations, map));
            ans = Math.max(ans,count(num-k, nums, k, numOperations, map));
            ans = Math.max(ans,count(num+k, nums, k, numOperations, map));
        }
        return ans;
    }
}