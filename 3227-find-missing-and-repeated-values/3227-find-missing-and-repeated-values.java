import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each number in the grid
        for (int[] row : grid) {
            for (int num : row) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        
        int repeated = -1, missing = -1;
        
        // Identify the repeated and missing numbers
        for (int num = 1; num <= size; num++) {
            if (countMap.getOrDefault(num, 0) == 2) {
                repeated = num;
            } else if (!countMap.containsKey(num)) {
                missing = num;
            }
        }
        
        return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();  // Create an instance of Solution
        
        int[][] grid1 = {{1, 3}, {2, 2}};
        int[][] grid2 = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        
        int[] result1 = solution.findMissingAndRepeatedValues(grid1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // [2, 4]

        int[] result2 = solution.findMissingAndRepeatedValues(grid2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // [9, 5]
    }
}

