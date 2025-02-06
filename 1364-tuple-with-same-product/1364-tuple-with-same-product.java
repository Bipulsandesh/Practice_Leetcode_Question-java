import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        
        // Count the frequency of each product
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                countMap.put(product, countMap.getOrDefault(product, 0) + 1);
            }
        }
        
        // Calculate the total number of tuples
        int total = 0;
        for (int count : countMap.values()) {
            total += count * (count - 1) * 4;
        }
        
        return total;
    }
}

