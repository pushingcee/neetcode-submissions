class Solution {
    int kth;
    int smallest; 
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        dfs(root);
        return smallest;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

  

        dfs(root.left);
        kth--;

        if(kth == 0) {
            smallest = root.val;
            return;
        }

        dfs(root.right);
    }

}
