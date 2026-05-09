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
    int maxDifference = 0;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return maxDifference <= 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        maxDifference = Math.max(maxDifference, Math.abs(left - right));

        return Math.max(left, right);
    }
}
