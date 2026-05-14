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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0; //we want to end, without affecting the overall result;
        }

        //I want ot have the sum just in case this is an "leaf" or "branch" of a bigger path
        int sum = root.val + Math.max(dfs(root.left), dfs(root.right));
        //I want ot have a full "joint" sum
        max = Math.max(root.val + dfs(root.left) + dfs(root.right), max);

        return sum > 0 ? sum : 0;
    }

}
