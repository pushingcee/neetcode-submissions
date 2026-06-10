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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> levels = new LinkedList();
        levels.add(root);

        while(!levels.isEmpty()) {
            int levelSize = levels.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = levels.poll();
                currentLevel.add(current.val);
                if(current.left != null) {
                    levels.offer(current.left);
                }

                if(current.right != null) {
                    levels.offer(current.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}
