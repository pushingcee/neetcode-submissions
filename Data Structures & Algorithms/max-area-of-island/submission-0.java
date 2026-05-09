class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        for(int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    maxIsland = Math.max(maxIsland, dfs(grid, r, c));
                }
            }
        }

        return maxIsland;

    }

    private int dfs(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return 1 +
            dfs(grid, r + 1, c) +
            dfs(grid, r, c + 1) +
            dfs(grid, r - 1, c) +
            dfs(grid, r, c - 1);
    }
}
