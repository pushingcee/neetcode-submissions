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
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = levels.size();
            while(levelSize > 0) {
                TreeNode current = levels.poll();   
                if(current.left != null) {
                    levels.add(current.left);
                }
                if(current.right != null) {
                    levels.add(current.right);
                } 
                currentLevel.add(current.val);
                levelSize --;
            }
           result.add(currentLevel);
        }

        return result;
    }
}
