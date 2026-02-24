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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverseLeaf(root, 0);
        return sum;
    }
    private void traverseLeaf(TreeNode node, int val){
        val = (val << 1) | node.val;
        if(node.left == null && node.right == null){
            sum += val;
            return;
        }
        if(node.left != null){
            traverseLeaf(node.left, val);
        }
        if(node.right != null){
            traverseLeaf(node.right, val);
        }
    }
}