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



public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
    }
    return dfs(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
}

private TreeNode dfs(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int mid = inorderMap.get(root.val);
    int leftSize = mid - inStart;

    root.left = dfs(preorder, preStart + 1, preStart + leftSize, inStart, mid - 1, inorderMap);
    root.right = dfs(preorder, preStart + leftSize + 1, preEnd, mid + 1, inEnd, inorderMap);

    return root;
}
}
