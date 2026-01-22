class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Long> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add((long) num);
        }

        int ops = 0;

        while (true) {
            boolean isSorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) return ops;

            long minSum = -1;
            int minIdx = -1;

            for (int i = 0; i < arr.size() - 1; i++) {
                long currentSum = arr.get(i) + arr.get(i + 1);
                if (minIdx == -1 || currentSum < minSum) {
                    minSum = currentSum;
                    minIdx = i;
                }
            }

            arr.set(minIdx, minSum);
            arr.remove(minIdx + 1);
            ops++;
        }
    }
}