class BSTIterator {
    List<Integer> list=new ArrayList();
    int index=0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */