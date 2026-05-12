class Solution {
    boolean[][] visited;
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }

        return max;
    }

    private int helper(int[][] grid, int row, int col){
        if (row > grid.length - 1 || row < 0 || col < 0 || col > grid[row].length - 1 || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + 
        helper(grid, row + 1, col) +
        helper(grid, row, col + 1) +
        helper(grid, row - 1, col) +
        helper(grid, row, col - 1);

    }
}
