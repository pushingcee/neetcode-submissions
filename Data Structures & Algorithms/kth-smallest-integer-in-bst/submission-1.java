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
    int kth;
    int smallest; 
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        dfs(root);
        return smallest;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        
        kth--;

        if(kth == 0) {
            smallest = root.val;
        }

        dfs(root.right);
    }
}
