import java.util.*;

class Solution {
    public int minCapability(int[] nums, int k) {
        int minReward = 1, maxReward = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;

        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int i = 0; i < totalHouses; i++) {
                if (nums[i] <= midReward) {
                    possibleThefts++;
                    i++;  // Skip adjacent house
                }
            }

            if (possibleThefts >= k)
                maxReward = midReward;
            else
                minReward = midReward + 1;
        }

        return minReward;
    }
}