import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { 
        this.val = val; 
    }
}

public class Solution { // <-- Change class name to Solution
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        
        while (i < traversal.length()) {
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            
            int numStart = i;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                i++;
            }
            int value = Integer.parseInt(traversal.substring(numStart, i));
            
            TreeNode node = new TreeNode(value);
            
            while (stack.size() > depth) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            
            stack.push(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop();
    }

    // Helper function to print tree in level order for verification
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add(null);
            }
        }
        
        // Remove trailing nulls for better output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root = solver.recoverFromPreorder(traversal);
        
        System.out.println(solver.levelOrderTraversal(root)); // Output: [1, 2, 5, 3, 4, 6, 7]
    }
}
// Program Create By: Bipul Singh