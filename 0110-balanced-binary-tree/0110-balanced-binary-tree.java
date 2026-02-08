class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=-1;
    }

    private int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=checkHeight(root.left);
        if(left==-1){
            return -1;
        }

        int right=checkHeight(root.right);
        if(right==-1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}