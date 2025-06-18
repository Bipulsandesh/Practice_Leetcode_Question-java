class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) return new int[0][];
        
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int min = nums[i];
            int mid = nums[i + 1];
            int max = nums[i + 2];

            if (max - min > k) {
                return new int[0][];
            }
            result.add(new int[]{min, mid, max});
        }

        return result.toArray(new int[0][]);
    }
}