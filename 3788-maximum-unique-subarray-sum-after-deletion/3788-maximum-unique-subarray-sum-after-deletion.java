class Solution {
    public int maxSum(int[] nums) {
        int sum = 0;
        Set<Integer> st = new HashSet<>();
        int mxNeg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                st.add(nums[i]);
            else
                mxNeg = Math.max(mxNeg, nums[i]);
        }
        for (int val : st) {
            sum += val;
        }
        if (st.size() > 0)
            return sum;
        else
            return mxNeg;
    }
}