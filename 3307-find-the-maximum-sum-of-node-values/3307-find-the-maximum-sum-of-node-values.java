class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long sum = 0;
    long cnt = 0;
    long sacrifice = Integer.MAX_VALUE;
    
    for (int num : nums) {
        long xorVal = num ^ k;
        sum += Math.max(xorVal, num);
        if (xorVal > num) {
            cnt++;
        }
        sacrifice = Math.min(sacrifice, Math.abs(num - xorVal));
    }
    return sum - (cnt % 2 == 1 ? sacrifice : 0);
    }
}