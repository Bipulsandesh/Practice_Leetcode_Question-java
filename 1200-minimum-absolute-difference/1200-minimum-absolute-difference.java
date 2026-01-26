class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min_diff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int curr_diff = Math.abs(arr[i] - arr[i + 1]);

            if (curr_diff < min_diff) {
                min_diff = curr_diff;
                res.clear();
                add_pair(arr[i], arr[i + 1], res);
            } else if (curr_diff == min_diff) {
                add_pair(arr[i], arr[i + 1], res);
            }
        }

        return res;
    }

    private void add_pair(int num1, int num2, List<List<Integer>> res) {
        List<Integer> pair = Arrays.asList(num1, num2);
        res.add(pair);
    }
}