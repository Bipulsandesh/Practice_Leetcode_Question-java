class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        for (int len = 2; len <= 9; len++) {

            for (int start = 1; start + len - 1 <= 9; start++) {

                int num = 0;
                int digit = start;

                // Build one sequential number.
                for (int k = 0; k < len; k++)
                    num = num * 10 + digit++;

                if (num >= low && num <= high)
                    ans.add(num);
            }
        }

        return ans;
    }
}