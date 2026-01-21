class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int curr = nums.get(i);
            if(curr == 2){
                res[i] = -1;
            }
            else{
                int t = Integer.numberOfTrailingZeros(~curr);
                res[i] = curr ^ (1 << (t-1));
            }
        }

        return res;
    }
}