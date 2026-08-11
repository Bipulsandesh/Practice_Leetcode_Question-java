class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        int length = nums.length;

        Set<Integer> storage = new HashSet<>();

        for (int num : nums) {
            storage.add(num);
        }

        int index = 1;

        // Find the sum of the longest consecutive prefix
        while (index < length && nums[index] == nums[index - 1] + 1) {
            prefixSum += nums[index];
            index++;
        }

        // Find the smallest missing integer
        while (storage.contains(prefixSum)) {
            prefixSum++;
        }

        return prefixSum;
    }
}