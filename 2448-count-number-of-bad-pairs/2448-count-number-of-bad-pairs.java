import java.util.*;

public class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        Map<Integer, Long> freqMap = new HashMap<>();
        long badPairs = 0;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            badPairs += i - freqMap.getOrDefault(diff, 0L);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1);
        }

        return badPairs;
    }
}