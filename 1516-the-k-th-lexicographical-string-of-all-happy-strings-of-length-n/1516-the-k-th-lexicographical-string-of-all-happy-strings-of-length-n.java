import java.util.ArrayList;
import java.util.List;

public class Solution {  // Ensure the class is named "Solution"
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings);
        
        // Return the k-th happy string if it exists, otherwise return an empty string
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }

    private void backtrack(int n, String current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                backtrack(n, current + ch, happyStrings);
            }
        }
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHappyString(1, 3)); // Output: "c"
        System.out.println(solution.getHappyString(1, 4)); // Output: ""
        System.out.println(solution.getHappyString(3, 9)); // Output: "cab"
    }
} // <-- create the name Bipul Singh;