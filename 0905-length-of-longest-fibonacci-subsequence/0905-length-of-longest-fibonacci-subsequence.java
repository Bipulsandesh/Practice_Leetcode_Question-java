import java.util.HashMap;
import java.util.Map;

public class Solution {  // Rename class to Solution
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;

        // Store the index of each number in arr
        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        // Iterate through all pairs (i, j)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int x = arr[j] - arr[i]; // Check if arr[j] - arr[i] exists in arr
                if (x < arr[i] && index.containsKey(x)) {
                    int k = index.get(x);
                    int key = k * n + i; // Unique key for (k, i) pair
                    int len = dp.getOrDefault(key, 2) + 1;
                    dp.put(i * n + j, len); // Store (i, j) pair in dp
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); // Now matches expected class name
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // Output: 5
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})); // Output: 3
    }
}

