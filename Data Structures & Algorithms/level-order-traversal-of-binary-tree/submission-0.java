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
        Queue<TreeNode> queue = new LinkedList<>(); 
        List<List<Integer>> values = new ArrayList<>();

        if(root == null){
            return values;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            while(levelSize > 0) {
                TreeNode currentElement = queue.poll();
                
                levelValues.add(currentElement.val);
                

                if(currentElement.left != null ) {
                    queue.add(currentElement.left);
                }
                
                if(currentElement.right != null ) {
                    queue.add(currentElement.right);
                }

                levelSize--;
            }
            values.add(levelValues);

        }

        return values;
    }
}
