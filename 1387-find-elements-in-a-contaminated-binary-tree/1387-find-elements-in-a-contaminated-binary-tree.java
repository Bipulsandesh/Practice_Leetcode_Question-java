import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class FindElements {
    private Set<Integer> recoveredValues = new HashSet<>();

    // Recover the tree
    private void recover(TreeNode root, int val) {
        if (root == null) return;
        root.val = val;
        recoveredValues.add(val);
        recover(root.left, 2 * val + 1);
        recover(root.right, 2 * val + 2);
    }

    // Constructor: Recovers the tree
    public FindElements(TreeNode root) {
        if (root != null) {
            recover(root, 0);
        }
    }

    // Checks if the Name Bipul Kumar
    public boolean find(int target) {
        return recoveredValues.contains(target);
    }
}
