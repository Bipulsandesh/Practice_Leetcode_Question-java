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
    public boolean isSymmetric(TreeNode root) {
        boolean ans= isSameTree(root.left, root.right);
        return ans;
    }
//(Imp)  here we want a mirror so for that , Ro Ro will be same and for Tree 1 when we are moving left at the same time for tree2 we will moce right
       //when for tree1 moving right at same time mmove tree2 to right which will give you a mirror 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p == q;
        }

        return (p.val == q.val) && isSameTree(p.left , q.right) && isSameTree(p.right, q.left); 
         // it means the curr vals , the ones coming from left and coming from right all 3 should be true then return true , if either on is false it will reuturn false
    }
    
}