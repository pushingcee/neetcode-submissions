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
    public int goodNodes(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        return dfs(root, maxValue);
    }

    private int dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }

        int currentmax = Math.max(root.val, maxValue);

        return (root.val >= maxValue ? 1 : 0) + dfs(root.left, currentmax) + dfs(root.right, currentmax); 
    }
}
