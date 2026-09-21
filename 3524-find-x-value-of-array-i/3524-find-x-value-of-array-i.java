class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long ans[] = new long[k];
        long prev[] =new long[k];

        prev[nums[0]%k]++;
        ans[nums[0]%k]++;

        for(int i=1;i<n;i++){
            long arr[] = new long[k];
            ans[nums[i]%k]++;
            arr[nums[i]%k]++;
            for(int r=0;r<k;r++){
                int newRem = (int)((1L*r*nums[i])%k);
                ans[newRem]+=prev[r];
                arr[newRem]+= prev[r];
            }
            prev = arr.clone();
        }

        return ans;
    }
}