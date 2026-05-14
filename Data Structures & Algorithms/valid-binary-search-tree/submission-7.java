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
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int lowerBound, int upperBound) {
        //we've reached the bottom
        if(root == null) {
            return true;
        }

        return root.val > lowerBound && root.val < upperBound &&
         dfs(root.right, root.val, upperBound) && 
         dfs(root.left, lowerBound, root.val);
    }

}
