import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            // Add pairs formed by the new element
            int count = freq.getOrDefault(val, 0);
            pairs += count;
            freq.put(val, count + 1);

            // Shrink window from the left while we have enough pairs
            while (pairs >= k) {
                result += (n - right);  // all subarrays from left to right are valid
                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                pairs -= (leftCount - 1);  // removing nums[left] breaks (leftCount - 1) pairs
                if (leftCount == 1) {
                    freq.remove(leftVal);
                } else {
                    freq.put(leftVal, leftCount - 1);
                }
                left++;
            }
        }

        return result;
    }
}
