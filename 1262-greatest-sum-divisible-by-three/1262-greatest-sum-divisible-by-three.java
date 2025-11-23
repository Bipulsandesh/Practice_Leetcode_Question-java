class Solution {
    private int n;
    private Integer dp_array[][];
    public int maxSumDivThree(int[] nums) {
        n = nums.length;
        dp_array = new Integer[n][3];

        return helperMethod_dynamic_programming(nums, 0, 0);
    }

    public int helperMethod_dynamic_programming(int[] array, int index, int remainder) {
        if(index >= n)
            return remainder == 0 ? 0 : -1;
        if(dp_array[index][remainder] != null) {
            return dp_array[index][remainder];
        }

        int skip_case = helperMethod_dynamic_programming(array, index + 1, remainder);
        int take_case = helperMethod_dynamic_programming(array, index + 1, (remainder + array[index]) % 3);

        if(take_case != -1) {
            take_case += array[index];
        }

        int answer = Math.max(skip_case, take_case);
        dp_array[index][remainder] = answer;

        return answer;
    }
}