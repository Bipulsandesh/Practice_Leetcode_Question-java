import java.util.Arrays;

public class Solution { // Renamed class to Solution
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] result = new int[size]; // Initialize result array with zeros
        boolean[] used = new boolean[n + 1]; // Used to track numbers 1 to n

        backtrack(result, used, n, 0);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int n, int index) {
        if (index == result.length) {
            return true; // Successfully placed all numbers
        }

        if (result[index] != 0) {
            return backtrack(result, used, n, index + 1); // Skip filled positions
        }

        for (int num = n; num >= 1; num--) { // Try from largest to smallest
            if (used[num]) continue;

            if (num == 1) { // 1 appears only once
                result[index] = 1;
                used[num] = true;

                if (backtrack(result, used, n, index + 1)) {
                    return true;
                }

                result[index] = 0;
                used[num] = false;
            } else {
                int secondIndex = index + num;
                if (secondIndex < result.length && result[secondIndex] == 0) {
                    result[index] = result[secondIndex] = num;
                    used[num] = true;

                    if (backtrack(result, used, n, index + 1)) {
                        return true;
                    }

                    result[index] = result[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false; // No valid placement found
    }

    public static void main(String[] args) {
        Solution solver = new Solution(); // Use Solution class as expected
        System.out.println(Arrays.toString(solver.constructDistancedSequence(3))); // Expected Output: [3,1,2,3,2]
        System.out.println(Arrays.toString(solver.constructDistancedSequence(5))); // Expected Output: [5,3,1,4,3,5,2,4,2]
    }
}

