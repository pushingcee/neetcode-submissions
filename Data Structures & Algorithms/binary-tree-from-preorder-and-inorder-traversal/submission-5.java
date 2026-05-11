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
    Map<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int mid = preorder[preStart];
        int midIndex = inOrderMap.get(mid);           // absolute index in original inorder
        int leftSize = midIndex - inStart;            // number of nodes in left subtree

        TreeNode root = new TreeNode(mid);
        root.left  = dfs(preorder, preStart + 1, preStart + leftSize, inStart, midIndex - 1);
        root.right = dfs(preorder, preStart + leftSize + 1, preEnd,   midIndex + 1, inEnd);
        return root;
    }
}
