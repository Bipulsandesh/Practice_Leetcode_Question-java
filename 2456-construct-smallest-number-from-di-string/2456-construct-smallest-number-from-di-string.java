import java.util.*;

public class Solution {  // Rename class to Solution if required
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1); // Push numbers from 1 to n+1
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                // Pop from stack when encountering 'I' or at the end
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber("IIIDIDDD")); // Output: "123549876"
        System.out.println(solution.smallestNumber("DDD"));      // Output: "4321"
    }
}

