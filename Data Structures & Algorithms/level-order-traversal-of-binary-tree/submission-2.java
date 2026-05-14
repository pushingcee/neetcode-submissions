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
            int levelSnapshot = levels.size();
            //because it's a queue, we're always going to be FIFO
            List<Integer> level = new ArrayList(); 
            while(levelSnapshot > 0) {
                TreeNode current = levels.remove();

                if (current.left != null) {
                    levels.add(current.left);
                }

                if (current.right != null) {
                    levels.add(current.right);
                }

                level.add(current.val);
                levelSnapshot--;
            }
            result.add(level);
        }

        return result;
    }
}
