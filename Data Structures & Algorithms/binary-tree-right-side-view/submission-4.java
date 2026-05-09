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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return List.of();
        }   

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();
            TreeNode current = null;

            for(int i = 0; i < levelSize; i++) {
                current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }

                
                if(current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(current.val);
        }

        return result;
    }
}
