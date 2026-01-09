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
    class Pair{
        int depth;
        TreeNode node;
        Pair(int d, TreeNode n) {
            depth = d;
            node = n;
        }
    }
    public Pair dfs(TreeNode root) {
        if(root == null) return new Pair(0,null);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if(left.depth == right.depth) return new Pair(1 + left.depth,root);
        else if(left.depth > right.depth) return new Pair(1 + left.depth,left.node);
        else return new Pair(1 + right.depth,right.node);

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}