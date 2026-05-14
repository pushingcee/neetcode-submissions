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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean dfs(TreeNode root, int upperBound, int lowerBound) {
        if(root == null){
            return true;
        }

        return root.val > lowerBound && root.val < upperBound &&
            dfs(root.left, root.val, lowerBound) &&
            dfs(root.right, upperBound, root.val);

    }
}
