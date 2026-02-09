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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder =new ArrayList<>();
        getInorder(root,inorder);

        root=createBst(inorder,0,inorder.size()-1);

        return root;
    }
    public static void getInorder(TreeNode root, ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.val);
        getInorder(root.right,inorder);
    }

    public static TreeNode createBst(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;

        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = createBst(inorder,st,mid-1);
        root.right=createBst(inorder,mid+1,end);

        return root; 
    }
}