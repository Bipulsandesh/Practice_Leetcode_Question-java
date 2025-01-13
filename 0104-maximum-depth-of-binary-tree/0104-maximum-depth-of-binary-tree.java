/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int maxDepth = 0;
        if (root != null) {
            root.val = 1;
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val > maxDepth) {
                maxDepth = cur.val;
            }
            
            if (cur.left != null) {
                cur.left.val = cur.val + 1;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = cur.val + 1;
                queue.add(cur.right);
            }
        }
        return maxDepth;
    }
}