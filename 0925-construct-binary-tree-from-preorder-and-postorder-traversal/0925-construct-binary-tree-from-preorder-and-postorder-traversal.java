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
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int preIndex = 0;
    private HashMap<Integer, Integer> postIndexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int left, int right) {
        if (left > right || preIndex >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) return root; // Leaf node condition

        // Find left subtree root in postorder to determine boundary
        int leftSubRootIndex = postIndexMap.get(preorder[preIndex]);

        // Recursively build left and right subtrees
        root.left = buildTree(preorder, postorder, left, leftSubRootIndex);
        root.right = buildTree(preorder, postorder, leftSubRootIndex + 1, right - 1);

        return root;
    }
}
